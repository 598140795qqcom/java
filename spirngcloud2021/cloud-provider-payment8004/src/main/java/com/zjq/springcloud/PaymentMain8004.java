package com.zjq.springcloud;

import com.zjq.springcloud.test.WatcherTest;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.KeeperException;
import org.apache.zookeeper.ZooDefs;
import org.apache.zookeeper.ZooKeeper;
import org.apache.zookeeper.data.Stat;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.io.IOException;

/**
 * @author Administrator
 * @title: PaymentMain8004
 * @projectName spirngcloud2021
 * @description: TODO
 * @date 2021/9/2 11:41
 */
@SpringBootApplication
@EnableDiscoveryClient
public class PaymentMain8004 {
/*    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8004.class, args);
    }*/
    public static void main( String[] args ) throws IOException, KeeperException, InterruptedException {
        //创建一个Zookeeper实例，第一个参数为目标服务器地址和端口，第二个参数为Session超时时间，第三个为节点变化时的回调方法
        ZooKeeper zk = new ZooKeeper("127.0.0.1:2181", 30000, new WatcherTest());

        String node = "/node2";
        Stat stat = zk.exists(node, false);
        if(null == stat){
            //创建一个节点，数据为test,不进行ACL权限控制，节点为永久性的
            String createResult = zk.create(node, "test".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
            System.out.println(createResult);
        }

        //取得/node2/test节点下的数据,返回byte[]
        byte[] b = zk.getData(node, false, stat);
        System.out.println(new String(b));
        String result=new String(b);
        zk.close();
    }
}
