package com.salesorderprocessing.domain;


import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

// applicable to class

@Constraint(validatedBy = AddressTypeValidator.class)
@Target({ElementType.TYPE,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface AddressTypeConstraint {

    String message() default "Accepted values (C,D,I,R)";

    // these 2 lines required by spring boot
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
