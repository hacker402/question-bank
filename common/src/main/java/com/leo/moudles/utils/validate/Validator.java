package com.leo.moudles.utils.validate;

import com.leo.moudles.exception.ValidException;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <p>
 * 验证类
 * </p>
 *
 * @param <T>
 * @author qingweiqu
 */
public class Validator<T> {

    private T data;
    private Predicate<T> predicate;
    private String errorMessage;
    private Function<String, ? extends RuntimeException> exceptionSupplier;

    public static <T> Validator create(T data, Predicate<T> predicate, String errorMessage) {
        Validator<T> validator = new Validator<>();
        validator.data = data;
        validator.predicate = predicate;
        validator.errorMessage = errorMessage;
        validator.exceptionSupplier = ValidException::new;

        return validator;
    }

    public static <T> Validator create(T data, Predicate<T> predicate, Function<String, ? extends RuntimeException> exceptionSupplier) {
        Validator<T> validator = new Validator<>();
        validator.data = data;
        validator.predicate = predicate;
        validator.errorMessage = "";
        validator.exceptionSupplier = exceptionSupplier;

        return validator;
    }

    public boolean validate() {
        return predicate.test(data);
    }

    public RuntimeException getThrowable() {
        return exceptionSupplier.apply(String.format("验证错误：%s", errorMessage));
    }
}
