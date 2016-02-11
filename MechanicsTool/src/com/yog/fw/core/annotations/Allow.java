package com.yog.fw.core.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Yougeshwar
 * */
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface Allow {

}
