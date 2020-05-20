package uncomplete.tools;


//import org.apache.commons.codec.binary.Base64;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.NoSuchAlgorithmException;


/* *
 * @Author liuxy
 * @Description AES 双向加密解密工具
 * @Date 20:04 2018/2/11
 */
public class AESUtil {

    // 默认加密秘钥 AES加密秘钥为约定16位，小于16位会报错
    private static final String ENCODE_RULES = "WNH1rrgWV7eAQLC0";
    private static final String ENCODE_RULE2 = "TSINGHUAPBCSFAES";

    // 默认算法
    private static final String ALGORITHM_STR = "AES/CBC/PKCS5Padding";

    /**
     * 加密
     * @param content
     * @return
     */
    public static String aesEncode(String content) {
        return aesEncode(content, ENCODE_RULES);
    }

    /**
     * 解密
     * @param content
     * @return
     */
    public static String aesDecode(String content) {
        return aesDecode(content, ENCODE_RULES);
    }


    private AESUtil() {

    }

    /* *
     * @Description  加密 aes cbc模式
     * @Param [content]
     * @Return java.lang.String
     */
    public static String aesEncode(String content, String encryptKey) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(encryptKey.getBytes(), "AES");

            //根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
            //初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, keySpec, new IvParameterSpec(encryptKey.getBytes()));
            //获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte[] byteEncode = content.getBytes("utf-8");
            //根据密码器的初始化方式--加密：将数据加密
            byte[] byteAES = cipher.doFinal(byteEncode);
            //将加密后的byte[]数据转换为Base64字符串
            return Base64.getUrlEncoder().encodeToString(byteAES);
            //将字符串返回
        } catch (Exception e) {
            throw new RuntimeException("密文加密失败");
        }
        //如果有错就返加null


    }

    /* *
     * @Description 解密
     * @Param [cotent]
     * @Return java.lang.String
     */
    public static String aesDecode(String content, String decryptKey) {
        try {
            SecretKeySpec keySpec = new SecretKeySpec(decryptKey.getBytes("utf-8"), "AES");

            //根据指定算法AES自成密码器
            Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
            //初始化密码器，第一个参数为加密(Encrypt_mode)或者解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(decryptKey.getBytes("utf-8")));
            //8.将加密并编码base64后的字符串内容base64解码成字节数组
//            byte[] bytesContent = Base64.decodeBase64(content);
            byte[] bytesContent = Base64.getUrlDecoder().decode(content);
            /*
             * 解密
             */
            byte[] byteDecode = cipher.doFinal(bytesContent);
            return new String(byteDecode, "utf-8");
        } catch (NoSuchAlgorithmException e) {
        } catch (IllegalBlockSizeException e) {
            throw new RuntimeException("密文解密失败");
            //e.printStackTrace();
        } catch (NullPointerException e) {
            throw new RuntimeException("秘钥解析空指针异常");
        } catch (Exception e) {
            throw new RuntimeException("密文解密失败");
        }
        //如果有错就返null
        return null;

    }

    public static void main(String[] args) {
        String[] keys = {
               "18310019030"
        };
        System.out.println("key | AESEncode | AESDecode");
        for (String key : keys) {
            System.out.print(key + " | ");
            String encryptString = aesEncode(key, ENCODE_RULES);
            System.out.print(encryptString + " | ");
            String decryptString = aesDecode(encryptString, ENCODE_RULES);
            System.out.println(decryptString);
        }


//        System.out.println(AESUtil.aesEncode("15002779538","WNH1rrgWV7eAQLC0"));
//        System.out.println(AESUtil.aesDecode("IoYjmz8OnPhD82hD+oT+yw==","WNH1rrgWV7eAQLC0"));
    }




}
