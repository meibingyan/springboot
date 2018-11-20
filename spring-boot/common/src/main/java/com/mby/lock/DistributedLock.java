package com.mby.lock;

import org.I0Itec.zkclient.ZkClient;
import org.springframework.util.StringUtils;

import java.util.Collections;
import java.util.List;

public class DistributedLock {

    private final ZkClient zk;

    private String lockName;

    private String zkPath;

    private String lockPath;

    public DistributedLock() {
        zk = new ZkClient("127.0.0.1:2181");
    }


    /**
     * 尝试获取锁，获取失败的话，不需要再执行releaseLock
     *
     * @return true:获得锁成功, false:获得锁失败
     */
    public boolean getLock(String lockName) {
        if(!StringUtils.isEmpty(this.lockName)){
            return false;
        }

        this.lockName = lockName;
        this.zkPath = "/com/midea/jr/distributedLock/" + this.lockName;

        zk.createPersistent(this.zkPath, true);
        lockPath = zk.createEphemeralSequential(this.zkPath + "/" + this.lockName, null);
        List<String> nodes = zk.getChildren(this.zkPath);
        String firstNodeName = getFirstNodeName(nodes, this.lockName);
        nodes = null;
        if (lockPath.endsWith(firstNodeName)) {
            System.out.println(Thread.currentThread().getId() + "获取到" + lockPath);
            // 成功获取锁
            return true;
        }
        // 否则立即删除当前创建的锁节点
        releaseLock();
        return false;
    }


    /*
     * 主动释放锁
     */
    public void releaseLock() {

        if (lockPath != null) {
            zk.delete(lockPath, -1);
            try {
                zk.delete(zkPath);
            }catch (Exception e){

            }
            System.out.println(Thread.currentThread().getId() + "解锁" + lockPath);
            lockPath = null;
        }
    }


    private static String getFirstNodeName(List<String> nodeNames, String lockName) {
        // 节点名称格式为lockName000000000X，可按字符串简单排序
        Collections.sort(nodeNames);
        for (String nodeName : nodeNames) {
            if (nodeName.startsWith(lockName)) {
                return nodeName;
            }
        }
        return "";
    }

}
