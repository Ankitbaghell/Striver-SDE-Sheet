import java.util.*;

public class Solution {
    public static int calculateMinPatforms(int at[], int dt[], int n) {
        Arrays.sort(at);
        Arrays.sort(dt);

        int result = 1, curr_platforms = 1;
        int i = 1, j = 0;

        while (i < n && j < n) {
            if (at[i] <= dt[j]) { // extra platform required
                curr_platforms++;
                i++;
            } else if (at[i] > dt[j]) { // one platform will be free
                curr_platforms--;
                j++;
            }

            if (curr_platforms > result)
                result = curr_platforms;
        }

        return result;
    }
}