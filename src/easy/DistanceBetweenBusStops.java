package easy;

/**
 * 1184 Distance Between Bus Stops
 */
public class DistanceBetweenBusStops {
    public static void main(String[] args) {
        int[] dis=new int[]{7,10,1,12,11,14,5,0};
        System.out.println(distanceBetweenBusStops(dis,2,7));
    }
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        if(start>destination){
            return distanceBetweenBusStops(distance,destination,start);
        }
        int toStart = 0, toEnd = 0, dis = 0;
        for (int i = 0; i < start; i++) {
            toStart += distance[i];
        }
        for (int i = start; i < destination; i++) {
            dis += distance[i];
        }
        for (int i = destination; i < distance.length; i++) {
            toEnd += distance[i];
        }
        return Math.min(dis, toEnd + toStart);
    }
}
