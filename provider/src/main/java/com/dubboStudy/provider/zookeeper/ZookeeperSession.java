package com.dubboStudy.provider.zookeeper;

import org.apache.zookeeper.*;

import java.util.concurrent.CountDownLatch;

/**
 * @Author by ydj
 * @Date 2019/3/16下午9:25
 **/
public class ZookeeperSession {

    private ZooKeeper zooKeeper;

    private static CountDownLatch connectedSemaphore = new CountDownLatch(1);

    private static class Singleton{

        private static ZookeeperSession zookeeperSession ;
        static{
            zookeeperSession = new ZookeeperSession();
        }
        public static ZookeeperSession getInstance(){
            return zookeeperSession;
        }
    }

    private ZookeeperSession(){
        //去链接zookeeper server ，创建会话的时候，是异步进行的，所以需要一个监听器去告诉我们什么时候才是真的完成了链接
        try{
            this.zooKeeper = new ZooKeeper("127.0.0.1:2181",123,new ZookeeperWatcher());

            //打印一个状态 Connection，连接中
            System.out.println(zooKeeper.getState());

            //让它在这里等待
            /**
             * countDownLatch java多线程并发同步的一个工具类
             * 然后传入一些数字，1 、2、3都可以
             * 然后await()，如果不是0，那么就卡住，等待
             * 其他线程可以调用countDown()，减1
             * 如果数字减到0，那么之前在await的线程都会逃出阻塞的状态
             */
            connectedSemaphore.await();

            System.out.println("Zookeeper Service connected......");
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    private class ZookeeperWatcher implements Watcher{

        public void process(WatchedEvent watchedEvent) {
            System.out.println("Receive watched event: "+ watchedEvent.getState());

            if(Event.KeeperState.SyncConnected == watchedEvent.getState()){
                //上面定义的是1，countDown 调用一次-1
                connectedSemaphore. countDown();
            }
        }
    }
    public static ZookeeperSession getInstance(){
        return Singleton.getInstance();
    }

    /**
     * 初始化单例的链接方法
     */
    public static void init(){

    }

    /**
     * 分布式加锁
     * acquire 获取 distribute 分散 lock 锁
     */
    public void acquireDistributedLock(Long productId){
        String  path = "/product-lock-" + productId;

        try{
            zooKeeper.create(path,"".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);

            System.out.println("success  to acquire lock for productId [id=" + productId +"]");
        }catch (Exception e){

            //如果商品对应的锁，已经存在了，就是已经被别人抢到加锁了，这里会报错NodeExistsException

            int count = 0;
            while (true){
                try {
                    Thread.sleep(30);

                    zooKeeper.create(path,"".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.EPHEMERAL);
                }catch (Exception e1){
                    e1.printStackTrace();
                    count++;
                    continue;
                }
                System.out.println("Success to acquire lock for productId[id = "+productId +",count = "+count +"]");
                break;
            }
        }
    }

    /**
     * 在处理完业务逻辑后，释放锁
     * @param productId
     */
    public void releaseDistributedLock(Long productId){
        String path = "/product-lock-"+productId;
        try{
            zooKeeper.delete(path,-1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
