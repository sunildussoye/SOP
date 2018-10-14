package com.salesorderprocessing.domain;

import org.springframework.util.StringUtils;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class AddressTypeValidator implements ConstraintValidator<AddressTypeConstraint, String> {

    @Override
    public void initialize(AddressTypeConstraint addressType) {
    }

    @Override
    public boolean isValid(String addressType, ConstraintValidatorContext context) {

        if (!StringUtils.isEmpty(addressType)) {

            if (addressType.length() > 1 ||
                    !addressType.equals("C") && !addressType.equals("D") &&
                            !addressType.equals("I") && !addressType.equals("R"))
                return false;
        }
        // blank values captured by annotation @Notblank at field level
        return true;
    }
}

