package com.example.graduateWork.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Random;

@Service
public class SmsService {

    @Value("${smsc.login}")
    private String smscLogin;

    @Value("${smsc.password}")
    private String smscPassword;


    public void sendSms(String phoneNumber) {

        String randomCode = generateRandomCode();

        String message = "ваш код регистрации " + randomCode;

        String smscUrl = "https://smsc.ru/sys/send.php?login=" + smscLogin +
                "&psw=" + smscPassword +
                "&phones=" + phoneNumber +
                "&mes=" + message;

        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(smscUrl, String.class);

        System.out.println("SMS sent to " + phoneNumber + ": " + message);
        System.out.println("Response from smsЦЕНТР: " + response);
    }

    private String generateRandomCode() {
        Random random = new Random();
        int code = 1000 + random.nextInt(9000);
        return String.valueOf(code);
    }
}
