package com.util;

import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import com.github.pandachanv587.aesutil.exception.AESConfigParamsError;
import com.github.pandachanv587.aesutil.exception.CipherCreateError;

public class common {
	private static String key;
	private static String path;
	private byte[] plain;
	private byte[] bytes;

	public static void main(String[] args)
			throws IOException, InvalidKeyException, InvalidAlgorithmParameterException, BadPaddingException,
			IllegalBlockSizeException, AESConfigParamsError, CipherCreateError, NoSuchAlgorithmException {
		
	}

}
