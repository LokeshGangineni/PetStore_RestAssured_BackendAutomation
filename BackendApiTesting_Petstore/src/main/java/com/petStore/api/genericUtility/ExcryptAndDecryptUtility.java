package com.petStore.api.genericUtility;


	import javax.crypto.Cipher;
	import javax.crypto.KeyGenerator;
	import javax.crypto.SecretKey;
	import javax.crypto.spec.SecretKeySpec;
	import java.util.Base64;

	public class ExcryptAndDecryptUtility{

	    // Method to generate a secret AES key
	    public static SecretKey generateKey() throws Exception {
	        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
	        keyGen.init(128); // 128-bit AES encryption
	        return keyGen.generateKey();
	    }

	    // Method to encrypt a plain text using AES
	    public static String encrypt(String plainText, SecretKey secretKey) throws Exception {
	        Cipher cipher = Cipher.getInstance("AES");
	        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
	        byte[] encryptedBytes = cipher.doFinal(plainText.getBytes());
	        return Base64.getEncoder().encodeToString(encryptedBytes); // Convert bytes to readable format
	    }

	    // Method to decrypt an encrypted text using AES
	    public static String decrypt(String encryptedText, SecretKey secretKey) throws Exception {
	        Cipher cipher = Cipher.getInstance("AES");
	        cipher.init(Cipher.DECRYPT_MODE, secretKey);
	        byte[] decryptedBytes = cipher.doFinal(Base64.getDecoder().decode(encryptedText));
	        return new String(decryptedBytes);
	    }

	    public static void main(String[] args) {
	        try {
	            // Step 1: Generate secret key
	            SecretKey secretKey = generateKey();
	            System.out.println("secretkey " + secretKey);
	            // Step 2: Original message
	            String originalText = "SensitiveData123";

	            // Step 3: Encrypt the text
	            String encryptedText = encrypt(originalText, secretKey);
	            System.out.println("Encrypted Text: " + encryptedText);

	            // Step 4: Decrypt the text
	            String decryptedText = decrypt(encryptedText, secretKey);
	            System.out.println("Decrypted Text: " + decryptedText);

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
	}


