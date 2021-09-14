package com.zjq.springcloud.service;

import com.zjq.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 * @title: PaymentService
 * @projectName spirngcloud2021
 * @description: TODO
 * @date 2021/8/19 10:14
 */

public interface PaymentService {

    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") long id);
}
