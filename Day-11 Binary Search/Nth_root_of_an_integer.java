public class Solution {
    static double multiply(double mid, int n) {
        double ans = 1.0;
        for (int i = 0; i < n; i++)
            ans *= mid;
        return ans;
    }

    public static double findNthRootOfM(int n, long m) {
        double start = 1;
        double end = m;
        double precision = 1e-8;

        while ((end - start) > precision) {
            double mid = (start + end) / 2.0;
            if (multiply(mid, n) < m)
                start = mid;
            else
                end = mid;
        }

        return end;
    }
}