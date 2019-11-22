package uncomplete.test;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;

/**
 * 根据网络路径获取时长
 *
 * @author ZhangShaobo
 */
public class VideoInfoTest {

    public static void main(String[] args) {
        try {
            long size = getFileLength("https://unicornvideo.oss-cn-zhangjiakou.aliyuncs.com/user_video/75456805-8513-46be-b7d6-426245f70d3e.mp4");
            if (size / 1024 > 1024) {
                System.out.println((size / 1024) / 1024 + "mb");
            }else{
                System.out.println("视频大小：" + size / 1024 + "kb");
            }

        } catch (Exception e) {
            // TODO: handle exception
        }

        new Thread(() -> {

        }).start();
    }

    /**
     * 获取网络文件大小
     */
    private static long getFileLength(String downloadUrl) throws IOException {
        if (downloadUrl == null || "".equals(downloadUrl)) {
            return 0L;
        }
        URL url = new URL(downloadUrl);
        HttpURLConnection conn = null;
        try {
            conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("HEAD");
            conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows 7; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/47.0.2526.73 Safari/537.36 YNoteCef/5.8.0.1 (Windows)");
            return (long) conn.getContentLength();
        } catch (IOException e) {
            return 0L;
        } finally {
            conn.disconnect();
        }
    }
}

