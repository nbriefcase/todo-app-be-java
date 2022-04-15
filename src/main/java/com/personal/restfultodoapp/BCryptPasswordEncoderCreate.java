package com.personal.restfultodoapp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class BCryptPasswordEncoderCreate {
    public static void main(String[] args) {
        BCryptPasswordEncoder encode = new BCryptPasswordEncoder();
        for (int i = 0; i < 10; i++) {
            System.out.println(encode.encode("password"));
        }
    }
}
