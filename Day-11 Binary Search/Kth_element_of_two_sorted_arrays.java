public class Solution {
    public static int kthElement(int a[], int b[], int m, int n, int k) {
        if (a.length > b.length) {
            int[] temp = a;
            a = b;
            b = temp;
        }
        m = a.length;
        n = b.length;

        int low = 0;
        if (k - n > 0)
            low = k - n;
        int high = m;
        if (k < high)
            high = k;

        while (low <= high) {
            int aleft = (low + high) / 2;
            int bleft = k - aleft;
            int alm1 = (aleft == 0) ? Integer.MIN_VALUE : a[aleft - 1];
            int al = (aleft == m) ? Integer.MAX_VALUE : a[aleft];
            int blm1 = (bleft == 0) ? Integer.MIN_VALUE : b[bleft - 1];
            int bl = (bleft == n) ? Integer.MAX_VALUE : b[bleft];

            if (alm1 <= bl && blm1 <= al) {
                return Math.max(alm1, blm1);
            }

            else if (alm1 > bl)
                high = aleft - 1;
            else
                low = aleft + 1;
        }
        return -1;
    }
}
