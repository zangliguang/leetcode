package uncomplete.test.JsonOperater;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class Export {
    public static void main(String[] args) {
        String fileUrl="http://pic37.nipic.com/20140113/8800276_184927469000_2.png";
        String fileLocal="D:/home/1.png";
        try {
            downloadFile(fileUrl,fileLocal);
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    /**
     * 文件下载
     * @param fileUrl 下载路径
     * @param savePath 存放地址 示例：D:/ceshi/1.png
     * @throws Exception
     */
    public static void downloadFile(String fileUrl,String savePath) throws Exception {
        File file=new File(savePath);
        //判断文件是否存在，不存在则创建文件
        if(!file.exists()){
            file.createNewFile();
        }
        URL url = new URL(fileUrl);
        HttpURLConnection urlCon = (HttpURLConnection) url.openConnection();
        urlCon.setConnectTimeout(6000);
        urlCon.setReadTimeout(6000);
        int code = urlCon.getResponseCode();
        if (code != HttpURLConnection.HTTP_OK) {
            throw new Exception("文件读取失败");
        }
        DataInputStream in = new DataInputStream(urlCon.getInputStream());
        DataOutputStream out = new DataOutputStream(new FileOutputStream(savePath));
        byte[] buffer = new byte[2048];
        int count = 0;
        while ((count = in.read(buffer)) > 0) {
            out.write(buffer, 0, count);
        }
        try {
            if(out!=null) {
                out.close();
            }
            if(in!=null) {
                in.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
