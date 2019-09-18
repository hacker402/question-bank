package com.leo.modules.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * RequireLogin
 * </p>
 *
 * @author chenxiaohu
 * @date 2019-08-28 14:27:56
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RequireLogin {

    String value() default "";

}
