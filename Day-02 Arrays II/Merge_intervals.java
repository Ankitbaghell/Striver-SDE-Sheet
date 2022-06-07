import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        // step 1 : Sort the array based on start point
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> list = new ArrayList<>(); // to store intervals
        for (int[] interval : intervals) {
            if (list.size() == 0) { // first interval as it is
                list.add(interval);
            } else { // check for overlapping
                int[] prevInterval = list.get(list.size() - 1);
                if (interval[0] <= prevInterval[1]) { // curr start is less than prev end ==> overlapping
                    prevInterval[1] = Math.max(prevInterval[1], interval[1]); // extend the interval
                } else {
                    list.add(interval); // no overlapping
                }
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}