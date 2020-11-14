package com.project2.matmaungdung;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import com.project2.matmaungdung.aesutil.AESConfig;
import com.project2.matmaungdung.aesutil.AESLevel;
import com.project2.matmaungdung.aesutil.AESOperationMode;
import com.project2.matmaungdung.aesutil.AESPaddingMode;
import com.project2.matmaungdung.aesutil.AESUtil;
import com.project2.matmaungdung.aesutil.exception.AESConfigParamsError;
import com.project2.matmaungdung.aesutil.exception.CipherCreateError;

public class Util {
	private static AESLevel level = AESLevel.LEVEL_128;
	private static AESOperationMode operationMode;
	private static AESPaddingMode paddingMode;

	public static byte[] aesCBCEncryt(byte[] plain, String key) throws AESConfigParamsError, InvalidKeyException,
			InvalidAlgorithmParameterException, CipherCreateError, BadPaddingException, IllegalBlockSizeException {
		operationMode = AESOperationMode.CBC;
		paddingMode = AESPaddingMode.PKCS7Padding;
		AESConfig aesConfig = AESConfig.builder().key(key).level(level).operationMode(operationMode)
				.paddingMode(paddingMode).build();

		AESUtil aesUtil = new AESUtil(aesConfig);
		return aesUtil.encrypt(plain);

	}

	public static byte[] aesCBCDecrypt(byte[] bytes, String key)
			throws InvalidKeyException, InvalidAlgorithmParameterException, AESConfigParamsError, CipherCreateError,
			BadPaddingException, IllegalBlockSizeException {
		operationMode = AESOperationMode.CBC;
		paddingMode = AESPaddingMode.PKCS7Padding;
		AESConfig aesConfig = AESConfig.builder().key(key).level(level).operationMode(operationMode)
				.paddingMode(paddingMode).build();
		AESUtil aesUtil = new AESUtil(aesConfig);
		return aesUtil.decrypt(bytes);
	}

	public static byte[] aesCTREncrypt(byte[] plain, String key)
			throws InvalidKeyException, InvalidAlgorithmParameterException, AESConfigParamsError, CipherCreateError,
			BadPaddingException, IllegalBlockSizeException {
		operationMode = AESOperationMode.CTR;
		paddingMode = AESPaddingMode.NOPADDING;
		AESConfig aesConfig = AESConfig.builder().key(key).level(level).operationMode(operationMode)
				.paddingMode(paddingMode).build();
		AESUtil aesUtil = new AESUtil(aesConfig);
		return aesUtil.encrypt(plain);
	}

	public static byte[] aesCTRDecrypt(byte[] bytes, String key)
			throws InvalidKeyException, InvalidAlgorithmParameterException, AESConfigParamsError, CipherCreateError,
			BadPaddingException, IllegalBlockSizeException {
		operationMode = AESOperationMode.CTR;
		paddingMode = AESPaddingMode.NOPADDING;
		AESConfig aesConfig = AESConfig.builder().key(key).level(level).operationMode(operationMode)
				.paddingMode(paddingMode).build();
		AESUtil aesUtil = new AESUtil(aesConfig);
		return aesUtil.decrypt(bytes);
	}

	public static byte[] convertToByteFromPath(String s) throws IOException {
		return Files.readAllBytes(Paths.get(s));
	}
}
