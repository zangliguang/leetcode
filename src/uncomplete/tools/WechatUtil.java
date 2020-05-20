package uncomplete.tools;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.encoders.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.security.Key;
import java.security.Security;

/**
 * 微信工具类
 */
public class WechatUtil {

    public static void main(String[] args) {
//        System.out.println( decryptData(
//                "mDlanGr9YVGGOzlUxJgU4qxQPy3ggMEow0h2xsb/Q2/u77PWalZ6ZafPCjHqE6FKSAAmEO+9vXAnPVn7388zVTNFg5xKSvzUhxo6ZX68BihJHosPtwbIwAQa2XNA9i14iuUYW25558jkKGK+OKDUNtmWmNuhFPFi2KpFDRTwuCxMjCOPJ/n2QdAPhp7LjS9IXcxri1cuAiXv0gMdeT3OSA==",
//                "5qlh3i1Heh0V\\/T0BHKkWNQ==",
//                "vYlI9pIoxWZf+b8y/vSTtQ=="
//        ));
        String result = decryptData(
                "sDXrUftQyBSyY7M4Ro4Xvjl8amI2agPjUWkcJXTJx6qsqaeetGdE7bp7P7V95aU7TS6O6l9cSznKhw5dhvkjSE+2vH19SntKxvfNtWUJigVKgzB28ACPjROC/4tidR4mMjJO81HX9pMCjusMVdYy0YzlYvvtCgTUNIOHNByMSB5fJ+vXIMnw==",
                "9y9P6RqKVZiWg==",
                "Yi1SGcsMg=="
        );
        System.out.println(result);
//        System.out.println(getOpenIdAndSessionKey("021yn86A1rtwu90YXs8A1sPh6A1yn86C"));
        //{"session_key":"\/QG+r9+4+ojQZ9F\/WZ926g==","openid":"oPLO15M5hm6_2Vo-Hkvu0ctE6Q6w"}
    }



    public static String getOpenIdAndSessionKey(String jsCode) {
        try {
            URL url = new URL("https://api.weixin.qq.com/sns/jscode2session?appid=wx653cad636ac88a62&secret=58fee06ee88fbcfc25e1f9148e2c6d8e&grant_type=authorization_code&js_code="+ jsCode);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true); // 设置该连接是可以输出的
            connection.setRequestMethod("GET"); // 设置请求方式
            connection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

            BufferedReader br = new BufferedReader(new InputStreamReader(connection.getInputStream(), "utf-8"));
            String line = null;
            StringBuilder result = new StringBuilder();
            while ((line = br.readLine()) != null) { // 读取数据
                result.append(line);
            }
            connection.disconnect();

            return result.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 获取手机号
     * @param encryptDataB64
     * @param sessionKeyB64
     * @param ivB64
     * @return
     */
    public static String decryptData(String encryptDataB64, String sessionKeyB64, String ivB64) {
        return new String(
                decryptOfDiyIV(
                        Base64.decode(encryptDataB64),
                        Base64.decode(sessionKeyB64),
                        Base64.decode(ivB64)
                )
        );
    }

    private static final String KEY_ALGORITHM = "AES";
    private static final String ALGORITHM_STR = "AES/CBC/PKCS7Padding";
    private static Key key;
    private static Cipher cipher;

    private static void init(byte[] keyBytes) {
        // 如果密钥不足16位，那么就补足.  这个if 中的内容很重要
        int base = 16;
        if (keyBytes.length % base != 0) {
            int groups = keyBytes.length / base + (keyBytes.length % base != 0 ? 1 : 0);
            byte[] temp = new byte[groups * base];
            Arrays.fill(temp, (byte) 0);
            System.arraycopy(keyBytes, 0, temp, 0, keyBytes.length);
            keyBytes = temp;
        }
        // 初始化
        Security.addProvider(new BouncyCastleProvider());
        // 转化成JAVA的密钥格式
        key = new SecretKeySpec(keyBytes, KEY_ALGORITHM);
        try {
            // 初始化cipher
            cipher = Cipher.getInstance(ALGORITHM_STR, "BC");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 解密方法
     *
     * @param encryptedData 要解密的字符串
     * @param keyBytes      解密密钥
     * @param ivs           自定义对称解密算法初始向量 iv
     * @return 解密后的字节数组
     */
    private static byte[] decryptOfDiyIV(byte[] encryptedData, byte[] keyBytes, byte[] ivs) {
        byte[] encryptedText = null;
        init(keyBytes);
        try {
            cipher.init(Cipher.DECRYPT_MODE, key, new IvParameterSpec(ivs));
            encryptedText = cipher.doFinal(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encryptedText;
    }

}