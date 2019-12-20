package uncomplete.test.JsonOperater;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.io.File;
import java.io.IOException;

public class Operator {
    public static void main(String[] args) throws IOException {
//        String[] strs=new String[]{"1221","asdasd","asdasdas"};
//        ArrayList<String>list=new ArrayList<>();
//        list.add("asdas");
//        list.add("asdas");
//        list.add("asdas");
//        list.add("asdas");
//        String result = list.toString();
//        System.out.println(result.substring(1,result.length()-1));
        printURl(parseJson());

    }

    private static void renameFile(String market_link, String s) {
        String[] split = market_link.split("/");
        String fileName = split[split.length - 1];
        new File("videos/" + fileName).renameTo(new File("videos/" + s + fileName));
    }

    private static JSONArray parseJson() {
        String filePath = "/Users/zangliguang/Documents/liguang/leetcode/src/uncomplete/test/JsonOperater/videos.json";
        String jsonStr = JsonDemo.readToString(filePath);
        JSONArray jsonArray = JSONObject.parseObject(jsonStr).getJSONArray("feeds");
        return jsonArray;
    }

    private static void printURl(JSONArray jsonArray) {
//        new File("videos/").mkdir();
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject video = jsonArray.getJSONObject(i);
            String name = video.getString("caption");
            String market_link = video.getJSONArray("main_mv_urls").getJSONObject(1).getString("url");

//            System.out.println( market_link);


            try {
                int num = 61+i;
                System.out.println( num+"："+name);
                Export.downloadFile(market_link,"videos/"+num+".mp4");
            } catch (Exception e) {
                e.printStackTrace();
            }
//            new File("videos/" + name).mkdir();
//            new File("videos/" + name + "/product").mkdir();
//            new File("videos/" + name + "/market").mkdir();
//            new File("videos/" + name + "/team").mkdir();
//            new File("videos/" + name + "/" + video.getString("id")).createNewFile();
        }
//}
    }
}
