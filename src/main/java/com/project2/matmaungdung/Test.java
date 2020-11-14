package com.project2.matmaungdung;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import com.project2.matmaungdung.aesutil.exception.AESConfigParamsError;
import com.project2.matmaungdung.aesutil.exception.CipherCreateError;

public class Test {
	public static void main(String[] args) throws InvalidKeyException, InvalidAlgorithmParameterException, BadPaddingException, IllegalBlockSizeException, AESConfigParamsError, CipherCreateError {
		String s = "asdf";
		byte[] bs = s.getBytes();
		String key = "1234567890123456";
		System.out.println(Util.aesCTREncrypt(bs, key));
		

	}
}
