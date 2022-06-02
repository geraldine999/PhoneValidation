package com.example.phonevalidation;

import com.google.i18n.phonenumbers.NumberParseException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PhoneValidationApplication {


    public static void main(String[] args) throws NumberParseException {
        SpringApplication.run(PhoneValidationApplication.class, args);

    }



}
