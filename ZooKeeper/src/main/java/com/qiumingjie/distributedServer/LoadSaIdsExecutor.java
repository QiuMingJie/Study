package com.qiumingjie.distributedServer;

import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import java.io.IOException;
import java.util.List;

/**
 * @author QiuMingJie
 * @date 2019-12-31 9:46
 * @Description
 */
public class LoadSaIdsExecutor implements Watcher, Runnable, DataMonitor.DataMonitorListener {


    private DataMonitor dm;

    private ZooKeeper zk;

    private static final String znode = "/sas";

    private String hostName = "localhost:2181";

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    /*
     *初始化zookeeper及DataMonitor
     * 自己作为zookeeper的监控者，监控和zookeeper连接的变化
     * 自己作为DataMonitor的listener。当dm监控到变化时会调用executor执行业务操作
     */
    public LoadSaIdsExecutor() throws KeeperException, IOException {
        zk = new ZooKeeper(hostName, 300000, this);
        dm = new DataMonitor(zk, znode, null, this);
    }

    /**
     * 入口方法,测试用。
     */
    public static void main(String[] args) {
        try {
            new LoadSaIdsExecutor().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 作为单独线程运行
     */
    public void run() {
        try {
            synchronized (this) {
                while (!dm.dead) {

                    wait();
                }
            }
        } catch (InterruptedException e) {
        }
    }

    /*
     *作为zookeeper监控者的回调，直接传递事件给monitor的回调函数统一处理
     */
    @Override
    public void process(WatchedEvent event) {
        dm.process(event);
    }

    /*
     *当关闭时，让线程线继续走完
     */
    public void closing(int rc) {
        synchronized (this) {
            notifyAll();
        }
    }

    /*
     *监控到/saids变化后的处理类
     */
    static class SaIdsLoader extends Thread {

        List<String> saIds = null;

        //构造对象后直接启动线程
        public SaIdsLoader(List<String> saIds) {
            this.saIds = saIds;
            start();
        }

        @Override
        public void run() {
            System.out.println("------------加载开始------------");
            //业务处理的地方
            if (saIds != null) {
                saIds.forEach(id -> {
                    System.out.println(id);
                });
            }
            System.out.println("------------加载结束------------");

        }

    }

    /*
     *作为listener对外暴露的方法，在节点/saids变化时被调用。
     */
    public void changed(List<String> data) {
        new SaIdsLoader(data);
    }
}
