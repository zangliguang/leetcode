package easy;

/**
 * 1189. Maximum Number of Balloons
 */
public class MaximumNumberofBalloons {
    public static void main(String[] args) {
        maxNumberOfBalloons("nlaebolko");
    }
    public static int maxNumberOfBalloons(String text) {

        int B=0,A=0,L=0,O=0,N=0;
        char[] chars = text.toCharArray();
        for (int i = 0; i < chars.length; i++) {

            if(chars[i]=='b'){
                B++;
            }
            if(chars[i]=='a'){
                A++;
            } if(chars[i]=='l'){
                L++;
            } if(chars[i]=='o'){
                O++;
            }
            if(chars[i]=='n'){
                N++;
            }
        }
        L/=2;
        O/=2;

        System.out.println(B+","+A+","+L+"，"+O+"，"+N);
       return Math.min (Math.min(Math.min(L,O),B),Math.min(A,N));


    }
}
