package com.leo.moudles.utils;

import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;

import java.math.BigDecimal;
import java.text.MessageFormat;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * <p>
 * DataUtils
 * </p>
 *
 * @author qingweiqu
 */
public class DataUtils {

    private static final Integer NEW_SCALE = 1;

    public static final String SPLIT_SYMBOL = ",";

    public static final String EMPTY_STR = "";

    public static final String NULL_STR = "null";

    public static final String UTF_8_CODE = "UTF-8";

    public static final String URL_REGEX = "/";

    public static boolean isNull(Object originalObj) {
        return null == originalObj;
    }

    public static boolean isNotNull(Object originalObj) {
        return !isNull(originalObj);
    }

    public static boolean isBlank(String originalStr) {
        return DataUtils.EMPTY_STR.equals(originalStr);
    }

    public static boolean isEmptyStr(String originalStr) {
        return isNull(originalStr) || "".equals(originalStr);
    }

    public static boolean isNotEmptyStr(String originalStr) {
        return !isEmptyStr(originalStr);
    }

    public static boolean isNotNullEmptyStr(String originalStr) {
        return !isEmptyStr(originalStr) && !NULL_STR.equals(originalStr);
    }

    public static boolean isNotEqual(String originalData, String compareData) {
        return !originalData.equals(compareData);
    }

    public static boolean isNotEqual(Object originalData, Object compareData) {
        return !originalData.equals(compareData);
    }

    public static BigDecimal parseStrToDecimal(String orignalStr) {
        return new BigDecimal(orignalStr);
    }

    public static <T> Predicate<T> distinctByKey(Function<? super T, ?> keyExtractor) {
        Map<Object, Boolean> seen = new ConcurrentHashMap<>();
        return t -> seen.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    public static Double roundDouble(Double originalData) {
        BigDecimal bigDecimal = new BigDecimal(originalData);
        return bigDecimal.setScale(NEW_SCALE, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    public static String formatPlaceholder(String str, String... params) {
        if (DataUtils.isBlank(str)) {
            return "";
        }
        return MessageFormat.format(str, params);
    }

    public static String format(String target, Object... params) {
        if (target.contains("%s") && ArrayUtils.isNotEmpty(params)) {
            return String.format(target, params);
        }
        return target;
    }

    public static List<String> stringToStringList(String strArr, String regex) {
        return Arrays.stream(strArr.split(regex))
                .map(s -> s.trim())
                .collect(Collectors.toList());
    }


    public static String formatNum(String num, Boolean kBool) {
        StringBuffer sb = new StringBuffer();
        if (!StringUtils.isNumeric(num)) {
            return "0";
        }
        if (kBool == null) {
            kBool = false;
        }
        BigDecimal b0 = new BigDecimal("1000");
        BigDecimal b1 = new BigDecimal("10000");
        BigDecimal b2 = new BigDecimal("100000000");
        BigDecimal b3 = new BigDecimal(num);

        String formatNumStr = "";
        String nuit = "";

        // 以千为单位处理
        if (kBool) {
            if (b3.compareTo(b0) == 0 || b3.compareTo(b0) == 1) {
                return "999+";
            }
            return num;
        }
        // 以万为单位处理
        if (b3.compareTo(b1) == -1) {
            sb.append(b3.toString());
        } else if ((b3.compareTo(b1) == 0 && b3.compareTo(b1) == 1) || b3.compareTo(b2) == -1) {
            formatNumStr = b3.divide(b1).toString();
            nuit = "万";
        } else if (b3.compareTo(b2) == 0 || b3.compareTo(b2) == 1) {
            formatNumStr = b3.divide(b2).toString();
            nuit = "亿";
        }
        if (!"".equals(formatNumStr)) {
            int i = formatNumStr.indexOf(".");
            if (i == -1) {
                sb.append(formatNumStr).append(nuit);
            } else {
                i = i + 1;
                String v = formatNumStr.substring(i, i + 1);
                if (!v.equals("0")) {
                    sb.append(formatNumStr.substring(0, i + 1)).append(nuit);
                } else {
                    sb.append(formatNumStr.substring(0, i - 1)).append(nuit);
                }
            }
        }
        if (sb.length() == 0) {
            return "0";
        }
        return sb.toString();
    }

}