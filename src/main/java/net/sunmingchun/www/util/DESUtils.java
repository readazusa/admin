package net.sunmingchun.www.util;

import org.apache.commons.lang3.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

/**
 * Created by smc on 2015/11/25.
 * 对称加密
 */
public class DESUtils {

    private static Key key;
    private static String KEY_STR = "ZXCVBNM<>s?'+q_)(*&^%$#@!qmac";// 密钥
    private static String CHARSETNAME = "UTF-8";// 编码
    private static String ALGORITHM = "DES";// 加密类型

    public static String encrypt(String source,String keyStr) {
        String keyNewStr = KEY_STR;
        if(StringUtils.isNotBlank(keyStr)){
            keyNewStr = keyStr;
        }
        try {
            KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
            generator.init(new SecureRandom(keyNewStr.getBytes()));
            key = generator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        BASE64Encoder base64encoder = new BASE64Encoder();
        try {
            byte[] bytes = source.getBytes(CHARSETNAME);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            byte[] doFinal = cipher.doFinal(bytes);
            return base64encoder.encode(doFinal);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static String decrypt(String source,String keyStr) {
        String keyNewStr = KEY_STR;
        if(StringUtils.isNotBlank(keyStr)){
            keyNewStr = keyStr;
        }
        try {
            KeyGenerator generator = KeyGenerator.getInstance(ALGORITHM);
            generator.init(new SecureRandom(keyNewStr.getBytes()));
            key = generator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        BASE64Decoder base64decoder = new BASE64Decoder();
        try {
            byte[] bytes = base64decoder.decodeBuffer(source);
            Cipher cipher = Cipher.getInstance(ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, key);
            byte[] doFinal = cipher.doFinal(bytes);
            return new String(doFinal, CHARSETNAME);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
    /**
     * 对str进行DES加密
     *
     * @param source 加密字符串源
     * @return 密文字符串
     */
    public static String encrypt(String source) {
       return encrypt(source,null);
    }

    /**
     * 对str进行DES解密
     *
     * @param source 待解密字符串
     * @return 明文字符串
     */
    public static String decrypt(String source) {
        return decrypt(source,null);
    }
}
