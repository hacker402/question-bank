package com.leo.moudles.utils;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

public class DES {

	private static final String PASSWORD = "xsSearch~!@#$%^&";

	public static byte[] encrypt(byte[] datasource) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeySpecException, IllegalBlockSizeException,
			BadPaddingException {
		SecureRandom random = new SecureRandom();
		DESKeySpec desKey = new DESKeySpec(PASSWORD.getBytes());

		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		SecretKey securekey = keyFactory.generateSecret(desKey);

		Cipher cipher = Cipher.getInstance("DES");

		cipher.init(1, securekey, random);

		return cipher.doFinal(datasource);
	}

}
