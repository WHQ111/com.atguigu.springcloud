package com.atguigu.springcloud.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class PaymentService {
    public String paymentInfo_ok(Integer id) {
        return "线程池： " +Thread.currentThread().getName() + " paymentInfo_OK, id" + id + "\t" + "haha";
    }

    public String paymentInfo_Timeout(Integer id) {
        int timeNumber = 3;
        try{
            TimeUnit.SECONDS.sleep(timeNumber);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return "线程池： " +Thread.currentThread().getName() + " paymentInfo_OK, id" + id + "\t" + "haha";
    }
}
