package com.leo.moudles.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

public class Encoder {
    private static final Logger logger = LoggerFactory.getLogger(Encoder.class);
    /**
     * md5+Base64组合算法
     * @param str
     * @return
     * @throws NoSuchAlgorithmException
     * @throws UnsupportedEncodingException
     */
    public static final String md5Base64(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        BASE64Encoder base64en = new BASE64Encoder();
        String result = base64en.encode(md5.digest(str.getBytes("utf-8")));
        return result;
    }

    //public static String md5Hex(String str) {
    //    MessageDigest md5 = null;
    //    String result = "";
    //    try {
    //        md5 = MessageDigest.getInstance("MD5");
    //    } catch (NoSuchAlgorithmException e) {
    //        logger.error("Encoder.md5Hex failed:", e);
    //    }
    //    byte[] datas = new byte[0];
    //    try {
    //        datas = str.getBytes("UTF-8");
    //    } catch (UnsupportedEncodingException e) {
    //        //e.printStackTrace();
    //        logger.error("Encoder.md5Hex failed 加密出错:", e);
    //    }
    //    if(md5 != null){
    //        byte[] bs = md5.digest(datas);
    //        result = new String(new Hex().encode(bs));
    //    }
    //    return result;
    //}
    
    /**
	 * 
	 * @param plainText
	 *            明文
	 * @return 32位密文
	 */
	public static String md5Hex32(String plainText) {
		String re_md5 = new String();
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(plainText.getBytes());
			byte b[] = md.digest();

			int i;

			StringBuffer buf = new StringBuffer("");
			for (int offset = 0; offset < b.length; offset++) {
				i = b[offset];
				if (i < 0){
                    i += 256;
                }
				if (i < 16){
                    buf.append("0");
                }
				buf.append(Integer.toHexString(i));
			}

			re_md5 = buf.toString();

		} catch (NoSuchAlgorithmException e) {
			//e.printStackTrace();
            logger.error("Encoder.md5Hex32 failed:", e);
		}
		return re_md5;
	}

    public static void main(String[] args) {
        try {
            System.out.println(md5Base64("payease889977@"));
            System.out.println(md5Base64("jf350524"));
            System.out.println(UUID.randomUUID().toString());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
