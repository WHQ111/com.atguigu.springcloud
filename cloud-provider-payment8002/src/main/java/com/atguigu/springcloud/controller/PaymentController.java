package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.entities.CommonResult;
import com.atguigu.springcloud.entities.Payment;
import com.atguigu.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class PaymentController {

    @Value("${server.port}")
    private String serverPort;

    @Autowired
    private PaymentService paymentService;

    @PostMapping("/payment/create")
    public CommonResult create(@RequestBody Payment payment) {
        int result = paymentService.create(payment);
        log.info("______插入结果：" + result);

        if (result > 0) {
            return new CommonResult(200, "插入成功" + serverPort, result);
        } else {
            return new CommonResult(444,"插入失败", null);
        }
    }

    @GetMapping("/payment/get/{id}")
    public CommonResult create(@PathVariable("id") Long id) {
        Payment result = paymentService.getPaymentById(id);
        log.info("______查询结果：" + result);

        if (result != null) {
            return new CommonResult(200, "查询成功" + serverPort, result);
        } else {
            return new CommonResult(444,"查询失败", null);
        }
    }


    @GetMapping(value = "/payment/lb")
    public String getPaymentLB() {
        return serverPort;
    }

}
