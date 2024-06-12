package com.example.graduateWork.config.security;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateExample {
    public static void main(String[] args) {
        Date date = new Date();

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        String formattedDate = formatter.format(date);

        System.out.println(formattedDate);
    }
}