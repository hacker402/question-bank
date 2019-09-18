package com.leo.moudles.utils.validate;

import com.leo.moudles.utils.DataUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * <p>
 * 数据验证工具类
 * </p>
 *
 * @author qingweiqu
 */
public class ValidateUtils {

    private List<Validator> validators = new ArrayList<>();

    public static ValidateUtils create() {
        return new ValidateUtils();
    }

    public static void notNull(Object data, String message) {
        ValidateUtils.create().append(data, DataUtils::isNotNull, message).validate();
    }

    public static void notEmptyStr(String originalStr, String message) {
        ValidateUtils.create().append(originalStr, DataUtils::isNotEmptyStr, message).validate();
    }

    public <T> ValidateUtils append(T data, Predicate<T> predicate) {
        return append(data, predicate, "");
    }

    public <T> ValidateUtils append(T data, Predicate<T> predicate, String errorMessage) {
        return append(Validator.create(data, predicate, errorMessage));
    }

    public <T> ValidateUtils append(T data, Predicate<T> predicate, Function<String, ? extends RuntimeException> exceptionSupplier) {
        return append(Validator.create(data, predicate, exceptionSupplier));
    }

    public ValidateUtils append(Validator validator) {
        validators.add(validator);
        return this;
    }

    public void validate() {
        validators.forEach(validator -> {
            if (!validator.validate()) {
                throw validator.getThrowable();
            }
        });
    }
}



