package easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1656. Design an Ordered Stream
 */
public class DesignanOrderedStream {
    class OrderedStream {

        String[] strs;

        int index=0;
        public OrderedStream(int n) {
            strs = new String[n];
            Arrays.fill(strs,null);
        }

        public List<String> insert(int idKey, String value) {
            List<String> result=new ArrayList<>();
            if(strs[idKey-1]==null){
                strs[idKey-1]=value;
            }
            if(idKey-1==index){

                for (int i = index; i <strs.length ; i++) {
                    if(strs[i]!=null){
                        result.add(strs[i]);
                    }else{
                        index=i;
                        break;
                    }


                }
            }

            return result;

        }
    }
}
