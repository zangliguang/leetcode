package medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 886 Possible Bipartition
 */
public class PossibleBipartition {
    public boolean possibleBipartition(int N, int[][] dislikes) {

        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i = 0; i < dislikes.length; i++) {
            int a = dislikes[i][0];
            int b = dislikes[i][1];
            map.putIfAbsent(a, new HashSet<>());
            map.putIfAbsent(b, new HashSet<>());
            map.get(a).add(b);
            map.get(b).add(a);
        }
        int[] colors = new int[N + 1];
        int color = 1;
        for (int i = 1; i < colors.length; i++) {
            if (colors[i] == 0 && !dfsColor(map, colors,i, color)) {
                return false;
            }


        }
        return true;
    }

    private boolean dfsColor(HashMap<Integer, HashSet<Integer>> map, int[] colors, int i, int color) {
        if(colors[i]!=0){
            return colors[i]==color;
        }
        colors[i]=color;
        HashSet<Integer> hashSet = map.get(i);
        if(hashSet==null){
            return true;
        }
        for (int o : hashSet) {
           if(!dfsColor(map,colors,o,-color)){
               return  false;
           }
        }

        return true;
    }
}
