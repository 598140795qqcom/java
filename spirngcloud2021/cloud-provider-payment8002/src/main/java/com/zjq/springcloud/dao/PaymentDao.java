package com.zjq.springcloud.dao;

import com.zjq.springcloud.entities.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author Administrator
 * @title: PaymentDao
 * @projectName spirngcloud2021
 * @description: TODO
 * @date 2021/8/19 9:50
 */
@Mapper
public interface PaymentDao {

    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") long id);
}
