package net.sunmingchun.test;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import javax.crypto.spec.DESKeySpec;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

/**
 * net.sunmingchun.test
 * Created by smc
 * date on 2016/4/27.
 * Email:sunmch@163.com
 */
public class DesTT {
    public static void main(String[] args) {
//
        System.out.println(DESKeySpec.DES_KEY_LEN);
        try {
            DESKeySpec desKeySpec = new DESKeySpec("12345678ss4".getBytes());
            Cipher cipher = Cipher.getInstance("DES");
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");

            SecretKey secretKey= secretKeyFactory.generateSecret(desKeySpec);

            cipher.init(Cipher.ENCRYPT_MODE,secretKey);
            try {
                BASE64Encoder base64encoder = new BASE64Encoder();
                byte[] bytes = cipher.doFinal("123".getBytes());
                System.out.println(base64encoder.encode(bytes));
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            }

        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
//            detye();
    }


    public static void detye(){
        String s = "LDiFUdf0iew=";
        try {
            DESKeySpec desKeySpec = new DESKeySpec("12345678".getBytes());
            Cipher cipher = Cipher.getInstance("DES");
            SecretKeyFactory secretKeyFactory = SecretKeyFactory.getInstance("DES");

            SecretKey secretKey= secretKeyFactory.generateSecret(desKeySpec);

            cipher.init(Cipher.DECRYPT_MODE,secretKey);
            try {
                BASE64Decoder decoder = new BASE64Decoder();
                byte[] bytes =null;
                try {
                    bytes = cipher.doFinal(decoder.decodeBuffer("LDiFUdf0iew="));
                    System.out.println(new String(bytes));
                } catch (IOException e) {
                    e.printStackTrace();
                }
//                System.out.println(decoder.);

            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            }

        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeySpecException e) {
            e.printStackTrace();
        }
    }
}
