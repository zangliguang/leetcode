package uncomplete;

import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.binary.StringUtils;


import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Logger;

/**
 * AES工具类
 *
 * @author yangguo
 */
public class AESUtils {

    private static final String KEY = "JR7k9nEWbYhcm7jpyQHCdA==";


    private static final String TRANSFORM = "AES/ECB/PKCS5Padding";
    private static final String KEY_ALGORITHM = "AES";

    public static void main(String[] args) {
        String encrypt = encrypt("8986012084232991900",KEY);
        System.out.println(encrypt);
    }

    /**
     * 加密
     *
     * @param data
     * @param key
     * @return
     */
    public static String encrypt(String data, String key) {
        try {
            byte[] KeyBytes = Base64.decodeBase64(key);
            System.out.println(Arrays.toString(KeyBytes));
            System.out.println(new String(KeyBytes, StandardCharsets.UTF_8));
            System.out.println(Base64.encodeBase64String(KeyBytes));

            SecretKeySpec secretKey = new SecretKeySpec(KeyBytes, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORM);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            byte[] result = cipher.doFinal(data.getBytes());
            return Base64.encodeBase64String(result);
        } catch (Exception e) {
            System.out.println("AES加密失败");
        }
        return "";
    }

    /**
     * 解密
     *
     * @param data
     * @param key
     * @return
     */
    public static String decrypt(String data, String key) {

        try {
            SecretKeySpec secretKey = new SecretKeySpec(Base64.decodeBase64(key), KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(TRANSFORM);
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            byte[] result = cipher.doFinal(Base64.decodeBase64(data));
            return new String(result);
        } catch (Exception e) {
//            logger.error("AES解密失败", e);
        }
        return "";
    }

    /**
     * 解密
     *
     * @param data
     * @return
     */
    public static String decrypt(String data) {
        return decrypt(data, KEY);
    }

    /**
     * 校验sign
     * 详见：https://xiaomi.f.mioffice.cn/docs/dock4HBKC4Gf3uIAhzzCKngUOJe#
     *
     * @param sign
     * @param params
     * @return
     */
    public static boolean checkSign(String sign, Map<String, String> params) {
        try {
//            logger.info("[AES参数校验] sign:{}, params:{}", sign, params);
//            if (MapUtils.isEmpty(params)) {
//                return "".equals(decrypt(sign));
//            }
            StringBuilder sb = new StringBuilder();
            List<String> keys = new ArrayList<>();
            for (String key : params.keySet()) {
                keys.add(key);
            }
            Collections.sort(keys);
            for (String key : keys) {
                sb.append(decrypt(params.get(key)));
            }
            return sb.toString().equals(decrypt(sign));
        } catch (Exception e) {
//            logger.error("[AES参数校验] 失败", e);
        }
        return false;
    }
}
