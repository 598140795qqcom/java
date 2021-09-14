package com.zjq.springcloud.service.impl;

import com.zjq.springcloud.dao.PaymentDao;
import com.zjq.springcloud.entities.Payment;
import com.zjq.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author Administrator
 * @title: PaymentServiceImpl
 * @projectName spirngcloud2021
 * @description: TODO
 * @date 2021/8/19 10:15
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public int update(Payment payment) {
        return paymentDao.update(payment);
    }

    public Payment getPaymentById(long id) {
        return paymentDao.getPaymentById(id);
    }
}
