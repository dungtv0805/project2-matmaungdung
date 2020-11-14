package com.github.pandachanv587.aesutil;

import com.github.pandachanv587.aesutil.exception.AESConfigParamsError;
import org.apache.commons.codec.binary.Base64;
import com.github.pandachanv587.aesutil.exception.CipherCreateError;
import com.github.pandachanv587.aesutil.util.CipherUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;

public class AESUtil {

    private Cipher encryptCipher;
    private Cipher decryptCipher;

    public AESUtil(String key) throws AESConfigParamsError, InvalidAlgorithmParameterException, InvalidKeyException, CipherCreateError {
        init(new AESConfig(key));
    }

    public AESUtil(AESConfig aesConfig) throws AESConfigParamsError, InvalidAlgorithmParameterException, InvalidKeyException, CipherCreateError {
        init(aesConfig);
    }

    private void init(AESConfig aesConfig) throws AESConfigParamsError, InvalidAlgorithmParameterException, InvalidKeyException, CipherCreateError {
        aesConfig.check();
        encryptCipher = CipherUtil.createCipher(CipherType.ENCRYPT, aesConfig);
        decryptCipher = CipherUtil.createCipher(CipherType.DECRYPT, aesConfig);
    }

    public byte[] encryptToBase64(String text) throws BadPaddingException, IllegalBlockSizeException {
        return Base64.encodeBase64(encrypt(text));
    }

    public byte[] encryptToBase64(byte[] bytes) throws BadPaddingException, IllegalBlockSizeException {
        return Base64.encodeBase64(encrypt(bytes));
    }

    public String encryptToBase64String(String text) throws BadPaddingException, IllegalBlockSizeException {
        return Base64.encodeBase64String(encrypt(text));
    }

    public String encryptToBase64String(byte[] bytes) throws BadPaddingException, IllegalBlockSizeException {
        return Base64.encodeBase64String(encrypt(bytes));
    }

    public byte[] encrypt(String text) throws BadPaddingException, IllegalBlockSizeException {
        return encrypt(text.getBytes(StandardCharsets.UTF_8));
    }

    public synchronized byte[] encrypt(byte[] bytes) throws BadPaddingException, IllegalBlockSizeException {
        return encryptCipher.doFinal(bytes);
    }

    public String decryptBase64String(String base64Text) throws BadPaddingException, IllegalBlockSizeException {
        return decryptToString(Base64.decodeBase64(base64Text));
    }

    public String decryptBase64String(byte[] base64Bytes) throws BadPaddingException, IllegalBlockSizeException {
        return decryptToString(Base64.decodeBase64(base64Bytes));
    }

    public byte[] decryptBase64(String base64Text) throws BadPaddingException, IllegalBlockSizeException {
        return decrypt(Base64.decodeBase64(base64Text));
    }

    public byte[] decryptBase64(byte[] base64Bytes) throws BadPaddingException, IllegalBlockSizeException {
        return decrypt(Base64.decodeBase64(base64Bytes));
    }

    public String decryptToString(byte[] bytes) throws BadPaddingException, IllegalBlockSizeException {
        return new String(decrypt(bytes), StandardCharsets.UTF_8);
    }

    public synchronized byte[] decrypt(byte[] bytes) throws BadPaddingException, IllegalBlockSizeException {
        return decryptCipher.doFinal(bytes);
    }

}
