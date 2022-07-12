import java.util.ArrayList;

public class Solution {
    public static ArrayList<Integer> stringMatch(String str, String pat) {
        int n = pat.length();
        int m = str.length();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i <= (m - n); i++) {
            boolean isMatched = true;
            for (int j = 0; j < n; j++) {
                if (str.charAt(j + i) != pat.charAt(j)) {
                    isMatched = false;
                    break;
                }
            }

            if (isMatched == true)
                ans.add(i);
        }

        return ans;
    }
}