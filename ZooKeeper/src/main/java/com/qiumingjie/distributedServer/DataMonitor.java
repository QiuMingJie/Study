package com.qiumingjie.distributedServer;

import org.apache.zookeeper.*;

import java.util.List;


/**
 * @author QiuMingJie
 * @date 2019-12-31 9:44
 * @Description
 */
public class DataMonitor implements Watcher, AsyncCallback.ChildrenCallback {


    ZooKeeper zk;

    String znode;

    Watcher chainedWatcher;

    boolean dead;

    DataMonitorListener listener;

    List<String> prevSaIds;

    public DataMonitor(ZooKeeper zk, String znode, Watcher chainedWatcher,
                       DataMonitorListener listener) {
        this.zk = zk;
        this.znode = znode;
        this.chainedWatcher = chainedWatcher;
        this.listener = listener;
        // 这是整个监控的真正开始，通过获取children节点开始。设置了本对象为监控对象，回调对象也是本对象。以后均是事件驱动。
        zk.getChildren(znode, true, this, null);
    }

    /**
     * 其他和monitor产生交互的类，需要实现此listener
     */
    public interface DataMonitorListener {
        /**
         * The existence status of the node has changed.
         */
        void changed(List<String> saIds);

        /**
         * The ZooKeeper session is no longer valid.
         *
         * @param rc
         *                the ZooKeeper reason code
         */
        void closing(int rc);
    }

    /*
     *监控/saids的回调函数。除了处理异常外。
     *如果发生变化，和构造函数中一样，通过getChildren，再次监控，并处理children节点变化后的业务
     */
    public void process(WatchedEvent event) {
        String path = event.getPath();
        if (event.getType() == Event.EventType.None) {
            // We are are being told that the state of the
            // connection has changed
            switch (event.getState()) {
                case SyncConnected:
                    // In this particular example we don't need to do anything
                    // here - watches are automatically re-registered with
                    // server and any watches triggered while the client was
                    // disconnected will be delivered (in order of course)
                    break;
                case Expired:
                    // It's all over
                    dead = true;
                    listener.closing(KeeperException.Code.SESSIONEXPIRED.intValue());
                    break;
            }
        } else {
            if (path != null && path.equals(znode)) {
                // Something has changed on the node, let's find out
                zk.getChildren(znode, true, this, null);
            }
        }
        if (chainedWatcher != null) {
            chainedWatcher.process(event);
        }
    }

    //拿到Children节点后的回调函数。
    public void processResult(int rc, String path, Object ctx, List<String> children) {
        boolean exists;
        switch (rc) {
            case KeeperException.Code.Ok:
                exists = true;
                break;
            case KeeperException.Code.NoNode:
                exists = false;
                break;
            case KeeperException.Code.SessionExpired:
            case KeeperException.Code.NoAuth:
                dead = true;
                listener.closing(rc);
                return;
            default:
                // Retry errors
                zk.getChildren(znode, true, this, null);
                return;
        }

        List<String> saIds = null;

        //如果存在，再次查询到最新children，此时仅查询，不要设置监控了
        if (exists) {
            try {
                saIds = zk.getChildren(znode,null);
            } catch (KeeperException e) {
                // We don't need to worry about recovering now. The watch
                // callbacks will kick off any exception handling
                e.printStackTrace();
            } catch (InterruptedException e) {
                return;
            }
        }

        //拿到最新saids后，通过listener（executor），加载Saids。
        if ((saIds == null && saIds != prevSaIds)
                || (saIds != null && !saIds.equals(prevSaIds))) {
            listener.changed(saIds);
            prevSaIds = saIds;
        }
    }

}
