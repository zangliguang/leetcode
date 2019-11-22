package uncomplete;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class JVM {
    public static void main(String[] args) {

        String origin = "https://unicornvideo.oss-cn-zhangjiakou.aliyuncs.com/user_video/49e1db58-1143-4f24-a5eb-a55e9d98e6ea.mp4https://unicornvideo.oss-cn-zhangjiakou.aliyuncs.com/user_video/e4cc73af-17d4-4be2-b4e6-5a16837fd1af.mp4";
        System.out.println(origin.substring(origin.indexOf(".mp4")+4));
    }

    public static String unicodeToString(String str) {

        Pattern pattern = Pattern.compile("(\\\\u(\\p{XDigit}{4}))");

        Matcher matcher = pattern.matcher(str);

        char ch;

        while (matcher.find()) {

            ch = (char) Integer.parseInt(matcher.group(2), 16);

            str = str.replace(matcher.group(1), ch + "");

        }

        return str;

    }
}
