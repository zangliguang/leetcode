package uncomplete.test;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Base64;
import javax.crypto.Cipher;

public class TestDemo {
    public static void main(String[] args) {
        int i=3;
        float result=1.0f;
        for (int j = 0; j < i; j++) {
            result/=2;
        }


    }

    // 加密
    public static String encrypt(String sSrc, String sKey) {
        if (sKey == null) {
            return null;
        }
        // 判断Key是否为16位
        if (sKey.length() != 16) {
            return null;
        }
        byte[] raw = sKey.getBytes();
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");// "算法/模式/补码方式"
            IvParameterSpec iv = new IvParameterSpec("0102030405060708".getBytes());// 使用CBC模式，需要一个向量iv，可增加加密算法的强度
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec);
            byte[] encrypted = cipher.doFinal(sSrc.getBytes());

            final Base64.Encoder encoder = Base64.getEncoder();
            return encoder.encodeToString(encrypted);// 此处使用BASE64做转码功能，同时能起到2次加密的作用。
        } catch (Exception e) {
        }
        return null;

    }

    private static void extracted(String aa) {
        char[] chars = aa.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            System.out.print(chars[i]);
        }
    }


//导入方法依赖的package包/类
    private static byte[] aesEncryptToBytes(String content, String encryptKey) throws Exception {
        KeyGenerator kgen = KeyGenerator.getInstance("AES");
        kgen.init(128, new SecureRandom(encryptKey.getBytes()));

        Cipher cipher = Cipher.getInstance("AES");
        cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(kgen.generateKey().getEncoded(), "AES"));



        byte[] bytes = cipher.doFinal(content.getBytes("utf-8"));
        final Base64.Encoder encoder = Base64.getEncoder();
        String str = new String(encoder.encode(bytes), "US-ASCII");
        System.out.println(str);
        return bytes;
    }


    private static String byte2Hex(byte[] bytes) {
        StringBuffer stringBuffer = new StringBuffer();
        String temp = null;
        for (int i = 0; i < bytes.length; i++) {
            temp = Integer.toHexString(bytes[i] & 0xFF);
            if (temp.length() == 1) {
// 1得到一位的进行补0操作
                stringBuffer.append("0");
            }
            stringBuffer.append(temp);
        }
        return stringBuffer.toString();
    }
}
