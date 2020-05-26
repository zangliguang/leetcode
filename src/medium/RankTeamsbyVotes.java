package medium;

import java.util.*;

/**
 * 1366. Rank Teams by Votes
 */
public class RankTeamsbyVotes {
    public static void main(String[] args) {
        String[] votes=new String[]{"ZMNAGUEDSJYLBOPHRQICWFXTVK"};
        System.out.println(rankTeams(votes));
    }
    public static String rankTeams(String[] votes) {
        Map<Character, int[]> map = new HashMap<>();
        int l = votes[0].length();
        for(String vote : votes){
            for(int i = 0; i < l; i++){
                char c = vote.charAt(i);
                map.putIfAbsent(c, new int[l]);
                map.get(c)[i]++;
            }
        }

        List<Character> list = new ArrayList<>(map.keySet());
        Collections.sort(list, (a,b) -> {
            for(int i = 0; i < l; i++){
                if(map.get(a)[i] != map.get(b)[i]){
                    return map.get(b)[i] - map.get(a)[i];
                }
            }
            return a - b;
        });

        StringBuilder sb = new StringBuilder();
        for(char c : list){
            sb.append(c);
        }
        return sb.toString();

    }
    static class Team {
        Character c;
        int num;

        public Team(Character c, int num) {
            this.c = c;
            this.num = num;
        }
    }
}
