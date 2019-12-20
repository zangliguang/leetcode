package easy;

/**
 * 1266. Minimum Time Visiting All Points
 */
public class MinimumTimeVisitingAllPoints {
    public int minTimeToVisitAllPoints(int[][] points) {
        if(points.length==1){
            return 0;
        }
        int result= 0 ;
        int x= points[0][0] ;
        int y= points[0][1] ;
        for (int i = 1; i < points.length; i++) {
            int x1= Math.abs(points[i][0]-x) ;
            int y1= Math.abs(points[i][1]-y) ;


            x= points[i][0] ;
            y= points[i][1] ;
            result+=Math.min(x1,y1)+Math.abs(x1-y1);
        }
        return result;

    }
}
