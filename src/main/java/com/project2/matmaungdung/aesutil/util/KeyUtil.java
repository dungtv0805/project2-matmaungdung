package com.project2.matmaungdung.aesutil.util;

import javax.crypto.spec.SecretKeySpec;

import com.project2.matmaungdung.aesutil.AESConfig;
import com.project2.matmaungdung.aesutil.AESLevel;

import java.nio.charset.StandardCharsets;

public class KeyUtil {

    private static final String AES_STRING = "AES";

    public static SecretKeySpec createSecretKeySpec(String key) {
        return createSecretKeySpec(key, AESLevel.DEFAULT);
    }

    public static SecretKeySpec createSecretKeySpec(AESConfig aesConfig) {
        return createSecretKeySpec(aesConfig.getKey(), aesConfig.getLevel());
    }

    protected static SecretKeySpec createSecretKeySpec(String key, AESLevel level) {
        byte[] keyBytes = new byte[level.getValue() / 8];
        byte[] passwordBytes = key.getBytes(StandardCharsets.UTF_8);
        int length = Math.min(passwordBytes.length, keyBytes.length);
        System.arraycopy(passwordBytes, 0, keyBytes, 0, length);
        return new SecretKeySpec(keyBytes, AES_STRING);
    }

}
