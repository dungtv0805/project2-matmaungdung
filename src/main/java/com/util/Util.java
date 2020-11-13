package com.util;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import com.github.pandachanv587.aesutil.AESConfig;
import com.github.pandachanv587.aesutil.AESLevel;
import com.github.pandachanv587.aesutil.AESOperationMode;
import com.github.pandachanv587.aesutil.AESPaddingMode;
import com.github.pandachanv587.aesutil.AESUtil;
import com.github.pandachanv587.aesutil.exception.AESConfigParamsError;
import com.github.pandachanv587.aesutil.exception.CipherCreateError;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Util {
	private static AESLevel level = AESLevel.LEVEL_256;
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

	public static byte[] aesCTREncrypt(byte[] plain, String key) throws InvalidKeyException, InvalidAlgorithmParameterException, AESConfigParamsError, CipherCreateError, BadPaddingException, IllegalBlockSizeException {
		operationMode = AESOperationMode.CTR;
		paddingMode = AESPaddingMode.NOPADDING;
		AESConfig aesConfig = AESConfig.builder().key(key).level(level).operationMode(operationMode)
				.paddingMode(paddingMode).build();
		AESUtil aesUtil = new AESUtil(aesConfig);
		return aesUtil.encrypt(plain);
	}
	
	public static byte[] aesCTRDecrypt(byte[] bytes, String key) throws InvalidKeyException, InvalidAlgorithmParameterException, AESConfigParamsError, CipherCreateError, BadPaddingException, IllegalBlockSizeException {
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
