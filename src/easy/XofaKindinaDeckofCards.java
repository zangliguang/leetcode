package easy;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.stream.Collectors;

/**
 * 914 X of a Kind in a Deck of Cards
 */
public class XofaKindinaDeckofCards {
    public boolean hasGroupsSizeX(int[] deck) {
        HashMap<Integer,Integer> map=new HashMap<>();

        for (int i : deck) {
            map.put(i,map.getOrDefault(i,0)+1);
        }



        Object[] os = map.values().stream().sorted().toArray();
        int[]array=new int[os.length];
        boolean res2=true;
        for (int i = 0; i < os.length; i++) {
            array[i]= (int) os[i];
            if(array[i]%2!=0){
                res2=false;
            }
        }
        if(res2){
            return true;
        }
//        Arrays.sort(array);

        if(array[0]<2){
            return false;
        }
        for (int i = 3; i <=array[0] ; i+=2) {
            boolean res=true;
            for (int j = 0; j < array.length; j++) {
                if(array[j]%i!=0){
                    res=false;break;
                }
            }
            if (res){
                return res;
            }

        }
        return false;
    }
}
