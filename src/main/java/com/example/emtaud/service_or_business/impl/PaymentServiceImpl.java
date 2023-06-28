package com.example.emtaud.service_or_business.impl;

import com.example.emtaud.service_or_business.PaymentService;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Override
    public void pay(float price) {
        System.out.println("Charging......");
    }
}
