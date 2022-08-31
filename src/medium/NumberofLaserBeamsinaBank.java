package medium;

/**
 * 2125. Number of Laser Beams in a Bank
 */
public class NumberofLaserBeamsinaBank {

    public static void main(String[] args) {
        String[] bank={"011001","000000","010100","001000"};
        System.out.println(numberOfBeams(bank));
    }
    public static int numberOfBeams(String[] bank) {
        if(bank.length<=1){
            return 0;
        }
        int value=0;
        String pre="",current="";
        for (int i = 0; i < bank.length; i++) {
            current=bank[i].replace("0","");
            if(current.length()==0){
                continue;
            }
            if(pre.length()==0){
                pre=current;
            }else {
                value+=current.length()*pre.length();
                pre=current;

            }
        }
        return value;

    }
}
