package com.ray.crm.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Usage: put @ValidEmail on the email field
 */
@Constraint(validatedBy = ValidEmailImpl.class)
@Target({ElementType.FIELD, ElementType.ANNOTATION_TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface ValidEmail {
	
	String message() default "Invalid email";
	
	Class<?>[] groups() default {};
	Class<? extends Payload>[] payload() default {};
}
