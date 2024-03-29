package com.zjq.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @author Administrator
 * @title: LoadBalancer
 * @projectName spirngcloud2021
 * @description: TODO
 * @date 2021/9/13 10:28
 */
public interface LoadBalancer {
    //收集服务器总共有多少台能够提供服务的机器，并放到list里面
    ServiceInstance instances(List<ServiceInstance> serviceInstances);

}
