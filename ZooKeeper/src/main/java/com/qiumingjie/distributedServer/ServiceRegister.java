package com.qiumingjie.distributedServer;

import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;

/**
 * @author QiuMingJie
 * @date 2019-12-31 9:42
 * @Description 分布式服务，这套代码监听分布式时服务器的状态
 */
public class ServiceRegister implements Runnable {


    private ZooKeeper zk;

    private static final String ZNODE = "/sas";

    private static final String SA_NODE_PREFIX = "sa_";

    private String hostName = "localhost:2181";

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public ServiceRegister() throws IOException {
        zk = new ZooKeeper(hostName, 10000, null);
    }


    public void run() {
        try {

            createSaNode();

            synchronized (this) {
                wait();
            }

        } catch (KeeperException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //测试用
    public static void main(String[] args) {
        try {
            new ServiceRegister().run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //创建子节点
    private String createSaNode() throws KeeperException, InterruptedException {
        // 如果根节点不存在，则创建根节点
        Stat stat = zk.exists(ZNODE, false);
        if (stat == null) {
            zk.create(ZNODE, new byte[0], ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        }

        String hostName = System.getenv("HOSTNAME");
        // 创建EPHEMERAL_SEQUENTIAL类型节点
        String saPath = zk.create(ZNODE + "/" + SA_NODE_PREFIX,
                hostName.getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE,
                CreateMode.EPHEMERAL_SEQUENTIAL);
        return saPath;
    }
}
