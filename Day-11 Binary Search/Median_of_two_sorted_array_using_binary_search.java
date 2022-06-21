
class Solution {
    public double findMedianSortedArrays(int[] a, int[] b) {
        if (a.length > b.length) { // if 'a' have more size than swap the arrays
            int[] temp = a;
            a = b;
            b = temp;
        }

        int low = 0;
        int high = a.length;
        int totalEle = a.length + b.length;

        while (low <= high) {
            int aleft = (low + high) / 2; // "mid" of array 'a' => no. of elements picked from array 'a'
            int bleft = (totalEle + 1) / 2 - aleft; // no. of elements picked from array 'b'

            // imp checks
            int alm1 = (aleft == 0) ? Integer.MIN_VALUE : a[aleft - 1]; // alm1 => aleft minus 1
            int al = (aleft == a.length) ? Integer.MAX_VALUE : a[aleft]; // al => aleft
            int blm1 = (bleft == 0) ? Integer.MIN_VALUE : b[bleft - 1]; // blm1 => bleft minus 1
            int bl = (bleft == b.length) ? Integer.MAX_VALUE : b[bleft]; // bl => bleft

            // checking the validation of partition/ segreagation
            if (alm1 <= bl && blm1 <= al) { // valid
                double median = 0.0;
                if (totalEle % 2 == 0) { // even no of elements
                    int leftMax = Math.max(alm1, blm1);
                    int rightMin = Math.min(al, bl);
                    median = (leftMax + rightMin) / 2.0;
                } else { // odd elements
                    median = Math.max(alm1, blm1); // bcz we are keeping one extra element in 'a' in case of odd no.
                }
                return median;
            }

            else if (alm1 > bl) { // there are more elements to be picked in left part of 'b' array
                high = aleft - 1;
            }

            else if (blm1 > al) { // there are more elements to be picked in left part of 'a' array
                low = aleft + 1;
            }
        }
        return 0;
    }
}