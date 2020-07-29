package medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 207 Course Schedule
 */
public class CourseSchedule {
    public static void main(String[] args) {
        int[][] prerequisites = new int[][]{{1, 0}, {1, 2}, {0, 1}};
        System.out.println(canFinish(3, prerequisites));
    }

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] preCourse = new int[numCourses];
        HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            int current = prerequisites[i][0];
            preCourse[current]++;
            map.putIfAbsent(prerequisites[i][1], new ArrayList<>());
            map.get(prerequisites[i][1]).add(current);
        }
        Queue queue = new LinkedList<Integer>();
        for (int i = 0; i < preCourse.length; i++) {
            if (preCourse[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer poll = (Integer) queue.poll();
            preCourse[poll] = -1;
            ArrayList<Integer> integers = map.get(poll);
            if (null != integers) {
                for (Integer element : integers) {
                    preCourse[element]--;
                    if (preCourse[element] == 0) {
                        queue.offer(element);
                    }

                }
            }


        }
        for (int value : preCourse) {
            if (value > 0) {
                return false;
            }
        }
        return true;


    }
}
