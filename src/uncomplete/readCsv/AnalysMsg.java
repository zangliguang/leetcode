package uncomplete.readCsv;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AnalysMsg {
    public static void main(String[] args) {
        readCSV("/Users/zangliguang/Documents/github/leetcode/src/uncomplete/readCsv/files/cmcc.csv");
        String str = "剩余总流量26.96GB";

//        regex(str);


    }

    private static void regex(String str) {
        String regexG = "[0-9]+(\\.[0-9]+)?G";
        ;


        Pattern p = Pattern.compile(regexG);

        Matcher m = p.matcher(str);

        while (m.find()) {

            System.out.println(m.group());

        }

        String regexM = "[0-9]+(\\.[0-9]+)?M";
        Pattern p2 = Pattern.compile(regexM);

        Matcher m2 = p2.matcher(str);

        while (m2.find()) {

            System.out.print(m2.group());

        }

    }


    public static void readCSV(String readpath) {


        //==========
        File inFile = new File(readpath);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inFile));
            boolean sign = false;       //用来跳过第一行的名称
            while (reader.ready()) {
                String line = reader.readLine();
                StringTokenizer st = new StringTokenizer(line, ",");
                int date, time, num_transaction, response_time;
                double sucRate;

                if (sign) {

                    String msg = line.split(",")[9];
                    String[] split = msg.split("\\\\n");
                    for (int i = 0; i < split.length; i++) {
                        System.out.println(line.split(",")[0] + "==" + split[i]);
                        regex(split[i]);
                    }
                } else {
                    sign = true;
                }
            }
            reader.close();

        } catch (FileNotFoundException e) {

            e.printStackTrace();
        } catch (IOException e) {

            e.printStackTrace();
        }
    }
}