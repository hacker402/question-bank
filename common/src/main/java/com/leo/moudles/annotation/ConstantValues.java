package com.leo.moudles.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * <p>
 * ConstantValues
 * </p>
 *
 * @author jackcooperz
 * @date 2019/8/12 9:27
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface ConstantValues {
}
