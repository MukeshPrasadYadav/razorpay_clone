package com.codingShuttle.razorpay_clone.common.util;

import java.security.SecureRandom;
import java.util.Base64;

public class RandomizerUtil {


    private static  final SecureRandom SECURE_RANDOM = new SecureRandom();
    public static String base64(int length){

        byte[] buff =  new byte[length/2];
        SECURE_RANDOM.nextBytes(buff);

        return Base64.getEncoder().withoutPadding().encodeToString(buff);
    }
}
