package medium;

/**
 * 1899. Merge Triplets to Form Target Triplet
 */
public class MergeTripletstoFormTargetTriplet {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        boolean a=false,b=false,c=false;
        for (int i = 0; i < triplets.length; i++) {

            if(triplets[i][0]==target[0]&&triplets[i][1]==target[1]&&triplets[i][2]==target[2]){
                return true;
            }
            if( !a&&triplets[i][0]==target[0]){
                a=triplets[i][1]<=target[1]&&triplets[i][2]<=target[2];
            }
            if( !b&&triplets[i][1]==target[1]){
                b=triplets[i][0]<=target[0]&&triplets[i][2]<=target[2];
            }
            if( !c&&triplets[i][2]==target[2]){
                c=triplets[i][0]<=target[0]&&triplets[i][1]<=target[1];
            }
        }
        return a&b&c;



    }
}
