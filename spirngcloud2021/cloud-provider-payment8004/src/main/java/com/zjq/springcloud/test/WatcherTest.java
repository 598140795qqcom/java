package com.zjq.springcloud.test;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;

public class WatcherTest implements Watcher{
    public void process(WatchedEvent arg0){
        System.out.println("========================");
        System.out.println("path:"+arg0.getPath());
        System.out.println("type:"+arg0.getType());
        System.out.println("state:"+arg0.getState());
    }
}