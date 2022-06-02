package com.example.phonevalidation;

@org.springframework.stereotype.Service
public class Service {

    public String validateCellphoneNumber(CellphoneNumberRequest request){
        return "Valid cellphone number";
    }
}
