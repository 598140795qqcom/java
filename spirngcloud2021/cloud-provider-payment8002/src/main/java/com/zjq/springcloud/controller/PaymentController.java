package com.zjq.springcloud.controller;

import com.zjq.springcloud.entities.CommonResult;
import com.zjq.springcloud.entities.Payment;
import com.zjq.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator
 * @title: PaymentController
 * @projectName spirngcloud2021
 * @description: TODO
 * @date 2021/8/19 10:19
 */
@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/create")
    public CommonResult<Payment> create(@RequestBody Payment payment){
        int result =paymentService.create((payment));
        log.info("插入结果"+result);
        if(result>0){
            return new CommonResult(200,"插入数据成功:serverPort"+serverPort,result);
        }else{
            return new CommonResult(500,"插入数据失败:serverPort"+serverPort,null);
        }
    }

    @GetMapping(value = "/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") long id) {
        Payment result = paymentService.getPaymentById((id));
        log.info("查询结果" + result);
        if (result != null) {
            return new CommonResult(200, "查询数据成功:serverPort"+serverPort, result);
        } else {
            return new CommonResult(500, "查询数据失败:serverPort"+serverPort, null);
        }
    }


    @GetMapping(value = "/payment/discovery")
    public Object discovery(){
        List<String> services = discoveryClient.getServices();
        for (String element : services) {
            log.info("***** element:"+element);
        }
        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        for (ServiceInstance instance : instances) {
            log.info(instance.getServiceId()+"\t"+instance.getHost()+"\t"+instance.getPort()+"\t"+instance.getUri());
        }
        return this.discoveryClient;
    }
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }
    @GetMapping(value = "/payment/feign/timeout")
    public String paymentFeignTimeout(){
        try { TimeUnit.SECONDS.sleep(3); }catch (Exception e) {e.printStackTrace();}
        return serverPort;
    }


}
