package com.yog.fw.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import com.yog.fw.core.enums.UserType;

/**
 * @author Yougeshwar
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface AllowTo {
	public UserType[] roles();
}
