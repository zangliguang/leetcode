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

//        Calendar c = Calendar.getInstance();
//        c.set(2020,1,-1);
//        int y = c.get(Calendar.YEAR);
//        int m = c.get(Calendar.MONTH);
//        int day = c.get(Calendar.DAY_OF_MONTH);
//        int maxDays = c.getActualMaximum(Calendar.DATE);
//        System.out.println(day);
//        System.out.println(maxDays);
//        String aa="类理管合综构机属直级省其及关机央中";
//        String bb="号4同胡河花莲区城⻄ 校学验实语国外武宣市京北";
//        extracted(aa);
//        System.out.println();
//        extracted(bb);
        final String JSON_KEY_APP_DEIVCE = "device";
        final String JSON_KEY_APP_VERSIONTPPE = "versionType";
        final String JSON_KEY_APP_REGION = "region";
        final String JSON_KEY_APP_APPVERSION = "appVersion";
        final String JSON_KEY_APP_MIUIVERSION = "miuiVersion";
        final String JSON_KEY_APP_CARRIER = "carrier";

        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("Carrier", "CMCC");
            jsonObject.put("Brand", 0);
            jsonObject.put("CITYID", "433");
            jsonObject.put("DataVersion", "0");
            jsonObject.put("PackageName", "com.miui.sdk.tc");
            jsonObject.put("SecKey", "aaaaaaaaaaaa");
        } catch (JSONException e) {
            e.printStackTrace();
        }
//        System.out.println(encrypt(jsonObject.toString(), "8vh8msy2hew9wqdx"));

        byte[] result ={-126, 30, 120, 85, 60, -115, 98, 7, -88, 68, -38, -127, -52, -100, -99, 13, -117, 4, -43, -28, -76, -114, 1, 63, 10, -106, -35, 123, -123, 53, 47, -72};
        byte[] key ={37, 30, -28, -10, 113, 22, 109, -120, 92, -101, -72, -23, -55, 1, -62, 116};


        final Base64.Encoder encoder = Base64.getEncoder();

        String str= null;
        try {
            str = new String(encoder.encode(key), "US-ASCII");
            System.out.println(byte2Hex(key));


            String iosStr= "9c3+OvyKJWu01zqasTXqPj2iLwpsh/Xj4xijjvzj2Oc=";
//            System.out.println(Arrays.toString("8986012084232991900".getBytes("utf-8")));
//            System.out.println(Arrays.toString(aesEncryptToBytes("8986012084232991900","JR7k9nEWbYhcm7jpyQHCdA==")));
//            System.out.println(Arrays.toString(iosStr.getBytes()));

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
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
