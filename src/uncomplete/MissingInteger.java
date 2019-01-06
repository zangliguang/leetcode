package uncomplete;

import java.util.*;

public class MissingInteger {

    public static void main(String[] args) {
        int[] A = new int[]{2,8,4,3,2};
        System.out.println(solution(A, 6, 12, 3));

    }


    public static int solution(int[] A, int X, int Y, int Z) {
        Dispensers d1 = new Dispensers(1, X, 0);
        Dispensers d2 = new Dispensers(2, Y, 0);
        Dispensers d3 = new Dispensers(3, Z, 0);
        int waitTime = 0;
        List<Dispensers> list = new ArrayList<>();
        for (int fuelNeed : A) {
            if (d1.capacity >= fuelNeed) {
                list.add(d1);
            }
            if (d2.capacity >= fuelNeed) {
                list.add(d2);
            }
            if (d3.capacity >= fuelNeed) {
                list.add(d3);
            }
            if (list.isEmpty()) {
                return -1;
            }
            Collections.sort(list, new Comparator<Dispensers>() {
                @Override
                public int compare(Dispensers o1, Dispensers o2) {
                    int value = o1.waitTime - o2.waitTime;

                    return value == 0 ? o1.num - o2.num : value;
                }
            });
            Dispensers dispensers = list.get(0);
            waitTime = Math.max(waitTime, dispensers.waitTime);
            dispensers.setValue(dispensers.capacity - fuelNeed, dispensers.waitTime + fuelNeed);

            if (dispensers.num == 1) {
                d1 = dispensers;
            } else if (dispensers.num == 2) {
                d2 = dispensers;
            } else {
                d3 = dispensers;
            }


            list.clear();
        }


        return waitTime;


    }

    static class Dispensers {
        public Dispensers(int num, int capacity, int waitTime) {
            this.num = num;
            this.capacity = capacity;
            this.waitTime = waitTime;
        }

        public void setValue(int capacity, int waitTime) {
            this.capacity = capacity;
            this.waitTime = waitTime;
        }

        int num;
        int capacity;
        int waitTime;

    }

//    public static int solution(int[] A) {
//        int maxHead = A[0];
//        int maxtail = A[0];
//        for (int i = 0; i < A.length; i++) {
//            maxHead = Math.max(maxHead, A[i] + i);
//            maxtail = Math.max(maxtail, A[i] - i);
//        }
//        return maxHead + maxtail;
//        // write your code in Java SE 8
//    }
}
