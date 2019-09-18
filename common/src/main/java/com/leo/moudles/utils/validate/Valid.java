package com.leo.moudles.utils.validate;


import com.leo.moudles.utils.ReflectUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 验证
 *
 * @author qingweiqu
 */
public class Valid {

    public static boolean inConstant(Object data, Class<?> clazz) {
        return ReflectUtils.getPublicStaticFields(clazz).stream()
                .map(ReflectUtils::getStaticFieldValue)
                .anyMatch(data::equals);
    }

    public static boolean isMobile(String mobile) {
        String regex = "^(13|15|17|18)\\d{9}$";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(mobile);
        return m.matches();
    }

    public static boolean isEquals(Object originalData, Object equalObject) {
        return originalData.equals(equalObject);
    }
}
