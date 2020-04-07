package com.james.example;

import java.security.MessageDigest;

/**
 * MD5加密工具
 * 2018-02-02
 */
public class MD5Util {

    private static final String SALT = "miguvideo";

    private MD5Util(){

    }

    public static String encode(String password) {
        password = password + SALT;
        MessageDigest md5;
        try {
            md5 = MessageDigest.getInstance("MD5");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        char[] charArray = password.toCharArray();
        byte[] byteArray = new byte[charArray.length];

        byte[] md5Bytes = new byte[byteArray.length];
        for (int i = 0; i < charArray.length; i++){
            byteArray[i] = (byte) charArray[i];
            md5Bytes = md5.digest(byteArray);
        }
        StringBuilder hexValue = new StringBuilder();
        for (int i = 0; i < md5Bytes.length; i++) {
            int val = ((int) md5Bytes[i]) & 0xff;
            if (val < 16) {
                hexValue.append("0");
            }
             hexValue.append(Integer.toHexString(val));
        }
        return hexValue.toString();
    }
}