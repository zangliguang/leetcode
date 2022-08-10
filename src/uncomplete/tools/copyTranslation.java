package uncomplete.tools;

import java.io.*;
import java.util.StringTokenizer;

public class copyTranslation {
    public static void main(String[] args) {

        String sourceDir="/Users/zangliguang/Documents/workspace/xiaomi/SecurityCenter/app/src/global/res";
        String targetDir="/Users/zangliguang/Documents/workspace/SecurityCenter/international/res";
        readCSV(sourceDir,targetDir);

    }



    public static void readCSV(String readpath,String writepath) {


        //==========
        File sourceDir = new File(readpath);
        File[] files = sourceDir.listFiles();
        for (File file : files) {

            File sf = new File(readpath + "/" + file.getName()+"/na_strings.xml");
            File tf = new File(writepath + "/" + file.getName()+"/na_strings.xml");
            if(sf.exists()&&tf.exists()){
                delete(tf,"</resources>");
//                System.out.println(tf.getAbsolutePath());
                readFile(sf,tf);
            }

        }

    }

    // 读取文件内容
    public static String readFile(File file,File tfile){
        StringBuilder result = new StringBuilder();
        try{
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), "UTF-8"));//构造一个BufferedReader类来读取文件

            String s = null;
            while((s = br.readLine())!=null){//使用readLine方法，一次读一行
                result.append( System.lineSeparator() + s);
                if(s.contains("network_assistant_privacy")){
                    System.out.println(s);
                    rewriteendline(tfile.getAbsolutePath(),s);
                    writeendline(tfile.getAbsolutePath(),"</resources>");
                }

            }
            br.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return result.toString();
    }





    public static void delete(File file, String text) {
        File temp = null;
        BufferedReader br = null;
        PrintWriter pw = null;
        try {
            temp = File.createTempFile("temp", "temp");
            pw = new PrintWriter(temp);
            br = new BufferedReader(new FileReader(file));
            while (br.ready()) {
                String line = br.readLine();
//                System.out.println(line);
                if (line.equals(text)) {
                    continue;
                }
                pw.println(line);
            }
            pw.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            safeClose(br);
            safeClose(pw);
            if (temp != null) {
                file.delete();
                temp.renameTo(file);
            }
        }
    }

    private static void safeClose(Closeable closeable) {
        if (closeable != null) {
            try {
                closeable.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void addContentToEnd(String file, String conent) {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new OutputStreamWriter(
                    new FileOutputStream(file, true), "UTF-8"));
            out.write(conent+"\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void fileOutputStreamMethod(String filepath, String content) throws IOException {
        try (FileOutputStream fileOutputStream = new FileOutputStream(filepath)) {
            byte[] bytes = content.getBytes();
            fileOutputStream.write(bytes);
        }
    }



    public static void writeendline(String filepath, String string)
            throws Exception {

        RandomAccessFile file = new RandomAccessFile(filepath, "rw");
        long len = file.length();
        long start = file.getFilePointer();
        long nextend = start + len - 1;
        byte[] buf = new byte[1];
        file.seek(nextend);
        file.read(buf, 0, 1);

        if (buf[0] == '\n')

            file.write(string.getBytes());
        else

            file.write(("\r\n"+string).getBytes());

        file.close();

    }

    public static void rewriteendline(String filepath, String string)
            throws Exception {

        RandomAccessFile file = new RandomAccessFile(filepath, "rw");
        long len = file.length();
        long start = file.getFilePointer();
        long nextend = start + len - 1;

        int i = -1;
        byte[] buf = new byte[1];

        while (nextend > start) {

            i = file.read(buf, 0, 1);
            if (buf[0] == '\r') {
                file.setLength(nextend - start);
                break;
            }
            nextend--;
            file.seek(nextend);

        }
        file.close();
        writeendline(filepath, string);

    }

    private static void copyFileUsingFileStreams(File source, File dest)
            throws IOException {
        InputStream input = null;
        OutputStream output = null;
        try {
            input = new FileInputStream(source);
            output = new FileOutputStream(dest);
            byte[] buf = new byte[1024];
            int bytesRead;
            while ((bytesRead = input.read(buf)) > 0) {
                output.write(buf, 0, bytesRead);
            }
        } finally {
            input.close();
            output.close();
        }
    }


}
