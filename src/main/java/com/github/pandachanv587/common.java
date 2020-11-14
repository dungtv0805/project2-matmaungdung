package com.github.pandachanv587;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.util.Scanner;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;

import org.apache.commons.io.FilenameUtils;

import com.github.pandachanv587.aesutil.exception.AESConfigParamsError;
import com.github.pandachanv587.aesutil.exception.CipherCreateError;

public class common {
	private static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws InvalidKeyException, InvalidAlgorithmParameterException,
			BadPaddingException, IllegalBlockSizeException, AESConfigParamsError, CipherCreateError, IOException {
		System.out.println("1: Aes/cbc encrypt");
		System.out.println("2: AES/CBC decrypt");
		System.out.println("3: AES/CTR encrypt");
		System.out.println("4: AES/CTR decrypt");
		System.out.println("Enter type:");
		String typeAES = sc.nextLine();

		switch (typeAES) {
		case "1":
			String path;
			while (true) {
				System.out.println("Absolute path:");
				String absolutePath = sc.nextLine();
				if (Files.exists(Paths.get(absolutePath))) {
					path = absolutePath;
					break;
				} else {
					System.out.println("path is wrong");
				}
			}
			String key;
			while (true) {
				System.out.println("Key (length 16 bytes):");
				String keyInput = sc.nextLine();
				if (keyInput.length() == 16) {
					key = keyInput;
					break;
				} else {
					System.out.println("length key is wrong");
				}
			}
			byte[] result = Util.aesCBCEncryt(Util.convertToByteFromPath(path), key);
			Path pathFolder = Paths.get(path).getParent();
			String fileName = Paths.get(path).getFileName().toString();
			FileOutputStream fos = new FileOutputStream(pathFolder + "/" +  writeFileNameEncrypt(fileName) + "-CBCencrypted" + "." + FilenameUtils.getExtension(path));
			fos.write(result);
			System.out.println("successfuly");
			break;
			
		case "2":
			String path2;
			while (true) {
				System.out.println("Absolute path:");
				String absolutePath = sc.nextLine();
				if (Files.exists(Paths.get(absolutePath))) {
					path2 = absolutePath;
					break;
				} else {
					System.out.println("path is wrong");
				}
			}
			String key2;
			while (true) {
				System.out.println("Key (length 16 bytes):");
				String keyInput = sc.nextLine();
				if (keyInput.length() == 16) {
					key2 = keyInput;
					break;
				} else {
					System.out.println("length key is wrong");
				}
			}
			byte[] result2 = Util.aesCTREncrypt(Util.convertToByteFromPath(path2), key2);
			Path pathFolder2 = Paths.get(path2).getParent();
			String fileName2 = Paths.get(path2).getFileName().toString();
			FileOutputStream fos2 = new FileOutputStream(pathFolder2 + "/" +  writeFileNameEncrypt(fileName2) + "-CBCdecrypted" + "." + FilenameUtils.getExtension(path2));
			fos2.write(result2);
			System.out.println("successfuly");
			break;
			
		case "3":
			String path3;
			while (true) {
				System.out.println("Absolute path:");
				String absolutePath = sc.nextLine();
				if (Files.exists(Paths.get(absolutePath))) {
					path3 = absolutePath;
					break;
				} else {
					System.out.println("path is wrong");
				}
			}
			String key3;
			while (true) {
				System.out.println("Key (length 16 bytes):");
				String keyInput = sc.nextLine();
				if (keyInput.length() == 16) {
					key3 = keyInput;
					break;
				} else {
					System.out.println("length key is wrong");
				}
			}
			byte[] result3 = Util.aesCTRDecrypt(Util.convertToByteFromPath(path3), key3);
			Path pathFolder3 = Paths.get(path3).getParent();
			String fileName3 = Paths.get(path3).getFileName().toString();
			FileOutputStream fos3 = new FileOutputStream(pathFolder3 + "/" +  writeFileNameEncrypt(fileName3) + "-CTRdecrypted" + "." + FilenameUtils.getExtension(path3));
			fos3.write(result3);
			System.out.println("successfuly");
			break;
			
		case "4":
			String path4;
			while (true) {
				System.out.println("Absolute path:");
				String absolutePath = sc.nextLine();
				if (Files.exists(Paths.get(absolutePath))) {
					path4 = absolutePath;
					break;
				} else {
					System.out.println("path is wrong");
				}
			}
			String key4;
			while (true) {
				System.out.println("Key (length 16 bytes):");
				String keyInput = sc.nextLine();
				if (keyInput.length() == 16) {
					key4 = keyInput;
					break;
				} else {
					System.out.println("length key is wrong");
				}
			}
			byte[] result4 = Util.aesCBCDecrypt(Util.convertToByteFromPath(path4), key4);
			Path pathFolder4 = Paths.get(path4).getParent();
			String fileName4 = Paths.get(path4).getFileName().toString();
			FileOutputStream fos4 = new FileOutputStream(pathFolder4 + "/" +  writeFileNameEncrypt(fileName4) + "-CTRdecrypted" + "." + FilenameUtils.getExtension(path4));
			fos4.write(result4);
			System.out.println("successfuly");
			break;
		default:
			break;
		}
	}

	private static String writeFileNameEncrypt(String fileName) {
		int i = fileName.lastIndexOf(".");
		int j = fileName.lastIndexOf("/");
		return fileName.substring(j+1, i);

	}
}
