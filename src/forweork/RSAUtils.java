package forweork;



import org.apache.commons.codec.binary.Base64;

import java.io.ByteArrayOutputStream;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

public class RSAUtils {

    public static final String KEY_ALGORITHM = "RSA";
    public static final String SIGNATURE_ALGORITHM = "SHA1WithRSA";
    public static final String ENCODING = "utf-8";
    public static final String X509 = "X.509";

    /**
     * 获取公钥
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static PublicKey getPublicKey(String key) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(key);
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PublicKey publicKey = keyFactory.generatePublic(keySpec);
        return publicKey;
    }

    /**
     * 获取私钥
     *
     * @param key
     * @return
     * @throws Exception
     */
    public static PrivateKey getPrivateKey(String key) throws Exception {
        byte[] keyBytes = Base64.decodeBase64(key.getBytes(ENCODING));
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return privateKey;
    }

    /**
     * RSA私钥签名
     *
     * @param content    待签名数据
     * @param privateKey 私钥
     * @return 签名值
     */
    public static String signByPrivateKey(String content, String privateKey) {
        try {
            PrivateKey priKey = getPrivateKey(privateKey);
            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initSign(priKey);
            signature.update(content.getBytes(ENCODING));
            byte[] signed = signature.sign();
            return new String(Base64.encodeBase64URLSafe(signed), ENCODING);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean verifySignByPublicKey(String content, String sign, String publicKey) {
        try {
            PublicKey pubKey = getPublicKey(publicKey);

            Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);
            signature.initVerify(pubKey);
            signature.update(content.getBytes(ENCODING));

            return signature.verify(Base64.decodeBase64(sign.getBytes(ENCODING)));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String encryptByPublicKey(String plainText, String publicKey) {
        try {
            PublicKey pubKey = getPublicKey(publicKey);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, pubKey);
            byte[] enBytes = cipher.doFinal(plainText.getBytes(ENCODING));
            return Base64.encodeBase64String(enBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String decryptByPrivateKey(String enStr, String privateKey) {
        try {
            PrivateKey priKey = getPrivateKey(privateKey);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            byte[] deBytes = cipher.doFinal(Base64.decodeBase64(enStr));
            return new String(deBytes);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String encryptByPrivateKey(String plainText, String privateKey) {
        try {
            byte[] data = plainText.getBytes();

            PrivateKey priKey = getPrivateKey(privateKey);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.ENCRYPT_MODE, priKey);
            int inputLen = data.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;

            for (int i = 0; inputLen - offSet > 0; offSet = i * 64) {
                byte[] cache;
                if (inputLen - offSet > 64) {
                    cache = cipher.doFinal(data, offSet, 64);
                } else {
                    cache = cipher.doFinal(data, offSet, inputLen - offSet);
                }

                out.write(cache, 0, cache.length);
                ++i;
            }
            byte[] encryptedData = out.toByteArray();
            out.close();
            return Base64.encodeBase64String(encryptedData);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 物联网对接浙江接口使用，其他方法调用时结果编码格式需要注意
     *
     * @param plainText
     * @param privateKey
     * @return
     */
    public static String decryptByPrivateKey2(String plainText, String privateKey) {
        try {
            byte[] encryptedData = Base64.decodeBase64(plainText.getBytes());
            PrivateKey priKey = getPrivateKey(privateKey);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
            cipher.init(Cipher.DECRYPT_MODE, priKey);
            int inputLen = encryptedData.length;
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            int offSet = 0;

            for (int i = 0; inputLen - offSet > 0; offSet = i * 75) {
                byte[] cache;
                if (inputLen - offSet > 75) {
                    cache = cipher.doFinal(encryptedData, offSet, 75);
                } else {
                    cache = cipher.doFinal(encryptedData, offSet, inputLen - offSet);
                }

                out.write(cache, 0, cache.length);
                ++i;
            }
            byte[] decryptedData = out.toByteArray();
            out.close();
            return new String(decryptedData, "GBK");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}