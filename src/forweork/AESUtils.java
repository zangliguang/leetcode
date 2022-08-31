package forweork;

import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.*;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

public class AESUtils {
    public static final String KEY_ALGORITHM = "AES"; //aes-128-ecb  默认trandformation为： AES/ECB/PKCS5Padding (128)
    public static final String ENCODING = "utf-8";

    public static String generateAESKey() {
        KeyGenerator keyGenerator = null;
        try {
            keyGenerator = KeyGenerator.getInstance(KEY_ALGORITHM);
        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        keyGenerator.init(128);
        SecretKey key = keyGenerator.generateKey();
        byte[] keyExternal = key.getEncoded();
        return Base64.encodeBase64String(keyExternal);
    }

    public static String encrypt(String content, String key) {
        try {
            byte[] bytesKey = Base64.decodeBase64(key);
            SecretKeySpec secretKey = new SecretKeySpec(bytesKey, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);// 创建密码器
            byte[] byteContent = content.getBytes(ENCODING);
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);// 初始化
            byte[] result = cipher.doFinal(byteContent);// 加密
            return Base64.encodeBase64String(result);
        } catch (Exception e) {
//            LOGGER.error("encrypt error", e);
        }
        return null;
    }

    public static String decrypt(String content, String key) {
        try {
            byte[] bytesKey = Base64.decodeBase64(key);
            SecretKeySpec secretKey = new SecretKeySpec(bytesKey, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, secretKey);// 初始化
            byte[] result = cipher.doFinal(Base64.decodeBase64(content));// 解密
            return new String(result);
        } catch (Exception e) {
//            LOGGER.error("decrypt error", e);
        }
        return null;
    }

    public static byte[] encrypt(byte[] byteContent, byte[] bytesKey) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(bytesKey, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);// 创建密码器
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);// 初始化
            byte[] result = cipher.doFinal(byteContent);// 加密
            return result;
        } catch (Exception e) {
//            LOGGER.error("encrypt error", e);
        }
        return null;
    }

    public static byte[] decrypt(byte[] byteContent, byte[] bytesKey) {
        try {
            SecretKeySpec secretKey = new SecretKeySpec(bytesKey, KEY_ALGORITHM);
            Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);// 创建密码器
            cipher.init(Cipher.DECRYPT_MODE, secretKey);// 初始化
            byte[] result = cipher.doFinal(byteContent);// 解密
            return result;
        } catch (Exception e) {
//            LOGGER.error("decrypt error", e);
        }
        return null;
    }

    private static String aesDecryptForNodeJs(String encrypted, String key) {
        try {
            byte[] keyb = key.getBytes("utf-8");
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] thedigest = md.digest(keyb);
            SecretKeySpec secretKey = new SecretKeySpec(thedigest, "AES");
            Cipher dcipher = Cipher.getInstance("AES");
            dcipher.init(Cipher.DECRYPT_MODE, secretKey);

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
     * @author lmiky
     * @date 2014-2-25
     * @param hexString
     * @return
     */
    private static byte[] toByte(String hexString) {
        int len = hexString.length() / 2;
        byte[] result = new byte[len];
        for (int i = 0; i < len; i++) {
            result[i] = Integer.valueOf(hexString.substring(2 * i, 2 * i + 2), 16).byteValue();
        }
        return result;
    }

    public static void main(String[] args) throws NoSuchAlgorithmException {
        String content = "test";
        String key = generateAESKey();
        System.out.println(key);
        System.out.println("加密前：" + content);
        // 加密
        String encryptResult = encrypt(content, key);
        // 解密
        String decryptResult = decrypt(encryptResult, key);
        System.out.println("解密后：" + new String(decryptResult));
    }




    /**
     * 算法逻辑
     * @param key
     * @param data
     * @return
     */
    public static byte[] Aes_Cmac01(byte[] key, byte[] data){
        // 子密钥生成
        // 步骤1，将具有密钥K的AES-128应用于全零输入块。
        byte[] L = AesEncrypt(key, new byte[16], new byte[16]);

        // 步骤2，通过以下操作得出K1：
        //如果L的最高有效位等于0，则K1是L的左移1位。
        byte[] FirstSubkey = Rol(L);
        if ((L[0] & 0x80) == 0x80) {
            // 否则，K1是const_Rb的异或和L左移1位。
            FirstSubkey[15] ^= 0x87;
        }

        // 步骤3，通过以下操作得出K2：
        //如果K1的最高有效位等于0，则K2是K1左移1位
        byte[] SecondSubkey = Rol(FirstSubkey);
        if ((FirstSubkey[0] & 0x80) == 0x80) {
            // 否则，K2是const_Rb的异或，且K1左移1位
            SecondSubkey[15] ^= 0x87;
        }


        // MAC 计算
        if (((data.length != 0) && (data.length % 16 == 0)) == true) {
            //如果输入消息块的大小等于块大小（128位）
            // 最后一个块在处理之前应与K1异或
            for (int j = 0; j < FirstSubkey.length; j++){
                data[data.length - 16 + j] ^= FirstSubkey[j];
            }

        } else {
            // 否则，最后一个块应填充10 ^ i
            byte[] padding = new byte[16 - data.length % 16];
            padding[0] = (byte) 0x80;
            byte[] newData=new byte[data.length+padding.length];
            System.arraycopy(data,0,newData,0,data.length);
            System.arraycopy(padding,0,newData,data.length,padding.length);
            //   data = data.Concat<byte>(padding.AsEnumerable()).ToArray();
            // 并与K2进行异或运算
            for (int j = 0; j < SecondSubkey.length; j++){
                newData[newData.length - 16 + j] ^= SecondSubkey[j];
            }
            data=newData;
        }
        // 先前处理的结果将是最后一次加密的输入。
        byte[] encResult = AesEncrypt(key, new byte[16], data);
        byte[] HashValue = new byte[16];
        System.arraycopy(encResult, encResult.length - HashValue.length, HashValue, 0, HashValue.length);

        return HashValue;
    }

    private static byte[] Rol(byte[] b)
    {
        byte[] r = new byte[b.length];
        byte carry = 0;

        for (int i = b.length - 1; i >= 0; i--)
        {
            short u = (short)(b[i] << 1);
            r[i] = (byte)((u & 0xff) + carry);
            carry = (byte)((u & 0xff00) >> 8);
        }
        return r;
    }

    /**
     * AES加密
     * @param keys
     * @param iv
     * @param data
     * @return
     */
    public static byte[] AesEncrypt(byte[] keys, byte[] iv, byte[] data)  {
        try {
            //1.根据字节数组生成AES密钥
            SecretKey key=new SecretKeySpec(keys, "AES");
            //2.根据指定算法AES自成密码器 "算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            //3.CBC模式需要向量vi
            IvParameterSpec ivps = new IvParameterSpec(iv);
            //4.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.ENCRYPT_MODE, key,ivps);
            //5.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte [] byte_encode=data;
            //6.根据密码器的初始化方式--加密：将数据加密
            byte [] byte_AES=cipher.doFinal(byte_encode);
            //7.返回
            return byte_AES;

        } catch (NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException | NoSuchPaddingException e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * AES解密
     * @param keys
     * @param iv
     * @param data
     * @return
     */
    public static byte[] AesDecrypt(byte[] keys, byte[] iv, byte[] data)  {
        try {
            //1.根据字节数组生成AES密钥
            SecretKey key=new SecretKeySpec(keys, "AES");
            //2.根据指定算法AES自成密码器 "算法/模式/补码方式"
            Cipher cipher = Cipher.getInstance("AES/CBC/NoPadding");
            //3.CBC模式需要向量vi
            IvParameterSpec ivps = new IvParameterSpec(iv);
            //4.初始化密码器，第一个参数为加密(Encrypt_mode)或者解密解密(Decrypt_mode)操作，第二个参数为使用的KEY
            cipher.init(Cipher.DECRYPT_MODE, key,ivps);
            //5.获取加密内容的字节数组(这里要设置为utf-8)不然内容中如果有中文和英文混合中文就会解密为乱码
            byte [] byte_decode=data;
            //6.根据密码器的初始化方式--加密：将数据加密
            byte [] byte_AES=cipher.doFinal(byte_decode);
            //7.返回
            return byte_AES;

        } catch (NoSuchAlgorithmException | InvalidKeyException | IllegalBlockSizeException | BadPaddingException | InvalidAlgorithmParameterException | NoSuchPaddingException e) {
            e.printStackTrace();
        }

        return null;
    }
}
