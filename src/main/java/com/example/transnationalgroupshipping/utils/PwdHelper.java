package com.example.transnationalgroupshipping.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PwdHelper {
    /**
     * @param password a password user entered
     * @return a hexadecimal password of length 32
     */
    public static String getHash(String password) {
        String hashedPassword = null;
        try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(password.getBytes());

            byte[] resultByteArray = digest.digest();
            StringBuilder result = new StringBuilder();
            for(byte bt : resultByteArray) {
                //change to hexadecimal
                result.append(String.format("%02x", bt));
            }
            hashedPassword = result.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return hashedPassword;
    }

}
