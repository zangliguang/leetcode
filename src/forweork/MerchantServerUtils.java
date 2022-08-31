package forweork;



import com.alibaba.fastjson.JSONObject;
import kotlin.Pair;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.MessageDigest;
import java.util.logging.Logger;

public class MerchantServerUtils {


    public static class ResponseCode {
        public static final int SUCCESS = 0;  //成功
        public static final int FAILED = 1;   //失败
        public static final int INNER_SERVER_ERROR = -1;  //内部其他错误
        public static final int UNKNOWN_NUMBER = 10;   //未知号码
        public static final int UNKNOWN_REQUEST = 11;  //未知请求类型
        public static final int ERROR_MERCHANTID = 100;// 商户ID填写错误
        public static final int SIGN_INVALID = 1000;  //验参错误
    }

    public final static String DATA = "data";
    public final static String PASS = "pass";
    public final static String MERCHANT_ID = "merchant_id";
    public final static String SIGN = "sign";

    public static boolean verifySign(JSONObject requestJson, String clientPublicKey) {
        String sign = requestJson.getString(SIGN);

        String bodyContent = getSignContent(requestJson);
        return RSAUtils.verifySignByPublicKey(bodyContent, sign, clientPublicKey);
    }

    public static String getAesKey(JSONObject requestJson, String serverPrivateKey) {
        String pass = requestJson.getString(PASS);

        System.out.println("pass=" + pass);
        return RSAUtils.decryptByPrivateKey(pass, serverPrivateKey);
    }

    public static String getData(JSONObject requestJson, String aesKey) {
        try {
            String data = requestJson.getString(DATA);
            return AESUtils.decrypt(data, aesKey);
        } catch (Exception e) {
//            LOGGER.error("getData", e);
        }
        return null;
    }

    public static String getData2(JSONObject requestJson, String aesKey) {
        try {
            String data = requestJson.getString(DATA);
            return aesDecryptForNodeJs(data, aesKey);
        } catch (Exception e) {
//            LOGGER.error("getData2", e);
        }
        return null;
    }

    private static String aesDecryptForNodeJs(String encrypted, String seed) {
        try {
            byte[] keyb = seed.getBytes("utf-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(keyb);
            SecretKeySpec skey = new SecretKeySpec(thedigest, "AES");
            Cipher dcipher = Cipher.getInstance("AES");
            dcipher.init(Cipher.DECRYPT_MODE, skey);

            byte[] clearbyte = dcipher.doFinal(toByte(encrypted));
            return new String(clearbyte);
        } catch (Exception e) {
            e.printStackTrace();
//            LOGGER.error("aesDecryptForNodeJs", e);
        }
        return null;
    }

    /**
     * 字符串转字节数组
     *
     * @param hexString
     * @return
     * @author lmiky
     * @date 2014-2-25
     */
    private static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
        }
        return result;
    }


    public static String getDataStr(JSONObject requestJson, String serverPrivateKey) {
        String data = requestJson.getString(DATA);
        String pass = requestJson.getString(PASS);

        String aesKey = RSAUtils.decryptByPrivateKey(pass, serverPrivateKey);

        String dataStr = AESUtils.decrypt(data, aesKey);
        return dataStr;
    }

    private static String getSignContent(JSONObject jsonObject) {
        // {data, partnerId, pass, sign}
        StringBuffer sb = new StringBuffer();
        if (jsonObject.getString(DATA) != null) {
            sb.append(DATA).append("=");
            sb.append(jsonObject.getString(DATA));
        }
        if (jsonObject.getString(MERCHANT_ID) != null) {
            sb.append("&").append(MERCHANT_ID).append("=");
            sb.append(jsonObject.getString(MERCHANT_ID));
        }
        if (jsonObject.getString(PASS) != null) {
            sb.append("&").append(PASS).append("=");
            sb.append(jsonObject.getString(PASS));
        }
        return sb.toString();
    }

    public static void generateMerchantRsaPairKey() throws Exception {
//        Pair<String, String> keyPair = RSASignature.generateKeyPair();
//        String publicKey = keyPair.getFirst();
//        String privateKey = keyPair.getSecond();
//        System.out.println("publickKey:" + publicKey);
//        System.out.println("privateKey:" + privateKey);
    }

//    public static String getMerchantPublicKey() throws Exception {
//        Pair<String, String> keyPair = RSASignature.generateKeyPair();
//        String publicKey = keyPair.getFirst();
//        return publicKey;
//    }

    public static void main(String[] args) throws Exception {
//        generateMerchantRsaPairKey();
    }

}
