package com.github.pandachanv587;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import com.github.pandachanv587.aesutil.exception.AESConfigParamsError;
import com.github.pandachanv587.aesutil.exception.CipherCreateError;

public class Test {
	public static void main(String[] args) throws InvalidKeyException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, AESConfigParamsError, CipherCreateError {
		String s = "asdf";
		byte[] bs = s.getBytes();
		String key = "1234567890123456";
		System.out.println(Util.aesCTREncrypt(bs, key));
		

	}
}
