package easy;

/**
 * Created by zangliguang on 2017/6/13.Num535
 */

import java.util.HashMap;

/**
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * <p>
 * Design the encode and decode methods for the TinyURL service. There is no restriction on how your encode/decode algorithm should work. You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 * <p>
 * Subscribe to see which companies asked this question.
 */
public class EncodeandDecodeTinyURL {
    public static void main(String[] args) {
        Codec codec = new Codec();
        codec.decode(codec.encode("asd"));
    }

    public static class Codec {

        HashMap<String, String> map = new HashMap();

        // Encodes a URL to a shortened URL.
        public String encode(String longUrl) {

            map.put(String.valueOf(longUrl.hashCode()), longUrl);
            return String.valueOf(longUrl.hashCode());
        }

        // Decodes a shortened URL to its original URL.
        public String decode(String shortUrl) {
            return map.get(shortUrl);

        }
    }
}
