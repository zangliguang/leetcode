package medium;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 785 Is Graph Bipartite
 */
public class IsGraphBipartite {
    public boolean isBipartite(int[][] graph) {
       int[] colors =new int[graph.length];
       int color=1;
        for (int i = 0; i < graph.length; i++) {
            if(colors[i]==0&&!dfs(graph,colors,i,color)){
                return false;
            }
        }

        return true;
    }

    private boolean dfs(int[][] graph, int[] colors, int i, int color) {
       if(colors[i]!=0){
           return colors[i]==color;
       }
        colors[i]=color;
        for (int j : graph[i]) {
            if(!dfs(graph,colors,j,-color)){
                return false;
            }
        }
        return true;
    }
}
