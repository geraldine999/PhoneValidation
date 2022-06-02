package com.example.phonevalidation;

import com.google.i18n.phonenumbers.PhoneNumberUtil;
import com.google.i18n.phonenumbers.Phonenumber;
import lombok.SneakyThrows;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CellphoneValidator implements ConstraintValidator<Cellphone, String> {

    @SneakyThrows
    @Override
    public boolean isValid(String cellphoneNumber, ConstraintValidatorContext constraintValidatorContext) {
        PhoneNumberUtil numberUtil = PhoneNumberUtil.getInstance();

        Phonenumber.PhoneNumber phoneNumber = numberUtil.parse(cellphoneNumber, "ARG");

        return numberUtil.isValidNumber(phoneNumber);

    }

    @Override
    public void initialize(Cellphone constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
