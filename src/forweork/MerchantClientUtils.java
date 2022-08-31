package forweork;


import com.alibaba.fastjson.JSONObject;
import org.bouncycastle.util.encoders.Base64;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


public class MerchantClientUtils {

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

    /**
     * 获取合法的请求参数LogId
     *
     * @param merchantId
     * @return
     */
    public static String getLogId(String merchantId) {
        String code = UUID.randomUUID().toString();
        if (merchantId == null || merchantId.length() == 0) {
            return code;
        }

        SimpleDateFormat formatDate = new SimpleDateFormat("yyyyMMddHHmmss");
        Date d = new Date(System.currentTimeMillis());
        String date = formatDate.format(d);

        return merchantId + "-" + date + code.hashCode();
    }

    /**
     * 创建requestData json格式
     *
     * @param data  原始数据
     * @param merchantId  商户ID
     * @param serverPublicKey  要调用的服务端提供的RSA的公钥
     * @param clientPrivateKey   调用方的RSA公钥，该公钥要告知服务端
     * @return
     */
    public static String createRequestData(String data, String merchantId, String serverPublicKey, String clientPrivateKey) {
        JSONObject responseData = new JSONObject();
        String aesKey = AESUtils.generateAESKey();
        if (aesKey == null) {
            return null;
        }
        responseData.put(DATA, AESUtils.encrypt(data, aesKey));
        responseData.put(MERCHANT_ID, merchantId);
        responseData.put(PASS, RSAUtils.encryptByPublicKey(aesKey, serverPublicKey));
        responseData.put(SIGN, RSAUtils.signByPrivateKey(getSignContent(responseData), clientPrivateKey));
        return responseData.toString();
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

    public static String generateUrlRequestData(String data, String merchantId, String serverPublicKey, String clientPrivateKey) {
        String requestData = createRequestData(data, merchantId, serverPublicKey, clientPrivateKey);
        try {
            return URLEncoder.encode(String.valueOf(Base64.encode(requestData.getBytes())), "UTF-8");
        } catch (UnsupportedEncodingException e) {
        }
        return "";
    }
}
