package com.project2.matmaungdung.aesutil.util;

import com.project2.matmaungdung.aesutil.AESConfig;
import com.project2.matmaungdung.aesutil.AESOperationMode;
import com.project2.matmaungdung.aesutil.AESPaddingMode;
import com.project2.matmaungdung.aesutil.CipherType;
import com.project2.matmaungdung.aesutil.exception.CipherCreateError;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Security;

public class CipherUtil {

    private static Boolean addBouncyCastleProviderFlag = false;

    private static final String AES_INSTANCE = "AES/";
    private static final String FORWARD_SLASH = "/";

    private static void addBouncyCastleProvider() {
        if (!addBouncyCastleProviderFlag) {
            Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
            addBouncyCastleProviderFlag = true;
        }
    }

    public static Cipher createCipher(CipherType cipherType, AESConfig aesConfig) throws InvalidAlgorithmParameterException,
            InvalidKeyException, CipherCreateError {
        Cipher cipher;
        addBouncyCastleProvider();

        try {
            cipher = Cipher.getInstance(getInstance(aesConfig.getOperationMode(), aesConfig.getPaddingMode()));
        } catch (Exception ignored) {
            throw new CipherCreateError("");
        }
        SecretKeySpec secretKeySpec = KeyUtil.createSecretKeySpec(aesConfig);

        if (aesConfig.getOperationMode() == AESOperationMode.CBC) {
            cipher.init(cipherType.getValue(), secretKeySpec, createIvParameterSpec());
        } else {
            cipher.init(cipherType.getValue(), secretKeySpec);
        }
        return cipher;
    }

    public static String getInstance(AESOperationMode operationMode, AESPaddingMode paddingMode) {
        return AES_INSTANCE + operationMode + FORWARD_SLASH + paddingMode;
    }

    private static IvParameterSpec createIvParameterSpec() {
        byte[] bytes = new byte[16];
        return new IvParameterSpec(bytes);
    }

}
