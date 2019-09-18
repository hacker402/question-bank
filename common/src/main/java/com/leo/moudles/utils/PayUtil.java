package com.leo.moudles.utils;

import java.util.Arrays;

/**
 * @author qingweiqu
 */
public class PayUtil {

    public static String GetSign(String[] ary, String key) {
        Arrays.sort(ary);
        // 对参数数组进行按key升序排列,然后拼接，最后调用MD5签名方法
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ary.length; i++) {
            sb.append(ary[i] + "&");
        }
        sb.append("key=" + key);
        String _str = sb.toString();
        return Md5Util.makeMd5Sum(_str.getBytes());
    }

    public static String GetParaStr(String[] ary, String sign) {
        Arrays.sort(ary);
        // 对参数数组进行按key升序排列,然后拼接，最后调用MD5签名方法

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ary.length; i++) {
            sb.append(ary[i] + "&");
        }
        sb.append("sign=" + sign);
        String _str = sb.toString();
        return _str;
    }

}
