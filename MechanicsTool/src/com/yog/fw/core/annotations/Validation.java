package com.yog.fw.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
public @interface Validation {
	public String message() default "";
	
	public boolean required() default false;
	
	public long min() default Long.MIN_VALUE;
	public long max() default Long.MAX_VALUE;
	
	public boolean isDate() default false;
	
	/**
	 * {@value} dd-MM-yyyy | now
	 * */
	public String minDate() default ""; 
	/**
	 * {@value} dd-MM-yyyy | now
	 * */
	public String maxDate() default "";
}
