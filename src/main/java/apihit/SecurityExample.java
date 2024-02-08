package apihit;

import javax.crypto.*;
import javax.crypto.spec.SecretKeySpec;

import java.security.*;

public class SecurityExample {
    private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES/ECB/PKCS5Padding";

    public static void main(String[] args) throws Exception {
        // Generate a secure random number
        SecureRandom secureRandom = new SecureRandom();
        byte[] key = new byte[16];
        secureRandom.nextBytes(key);

        // Encrypt the message
        String message = "This is a secure message.";
        byte[] encryptedMessage = encrypt(message.getBytes(), key);

        // Decrypt the message
        byte[] decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println(new String(decryptedMessage));
    }

    public static byte[] encrypt(byte[] plainText, byte[] key) throws Exception {
        Key secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        return cipher.doFinal(plainText);
    }

    public static byte[] decrypt(byte[] cipherText, byte[] key) throws Exception {
        Key secretKey = new SecretKeySpec(key, ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        return cipher.doFinal(cipherText);
    }
}