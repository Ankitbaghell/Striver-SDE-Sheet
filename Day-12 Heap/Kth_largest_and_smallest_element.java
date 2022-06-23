import java.util.*;

public class Solution {
    static int kthLargest(ArrayList<Integer> arr, int n, int k) {
        PriorityQueue<Integer> minpq = new PriorityQueue<>();
        for (int i = 0; i < k; i++)
            minpq.add(arr.get(i));

        for (int i = k; i < n; i++) {
            if (arr.get(i) > minpq.peek()) {
                minpq.remove();
                minpq.add(arr.get(i));
            }
        }
        return minpq.peek();
    }

    static int kthSmallest(ArrayList<Integer> arr, int n, int k) {
        PriorityQueue<Integer> maxpq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < k; i++)
            maxpq.add(arr.get(i));

        for (int i = k; i < n; i++) {
            if (arr.get(i) < maxpq.peek()) {
                maxpq.remove();
                maxpq.add(arr.get(i));
            }
        }
        return maxpq.peek();
    }

    public static ArrayList<Integer> kthSmallLarge(ArrayList<Integer> arr, int n, int k) {
        int largest = kthLargest(arr, n, k);
        int smallest = kthSmallest(arr, n, k);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(smallest);
        ans.add(largest);
        return ans;
    }
}
