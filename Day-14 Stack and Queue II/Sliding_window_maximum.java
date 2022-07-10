
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1]; // n-k+1 windows
        int index = 0;
        Deque<Integer> deque = new LinkedList<>(); // storing index
        for (int i = 0; i < nums.length; i++) {
            if (!deque.isEmpty() && deque.peek() == (i - k)) { // remove number out of window
                deque.removeFirst();
            }
            // removing numbers from back which are less than current number
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i])
                deque.removeLast();
            deque.addLast(i);

            if (i >= k - 1) {
                ans[index++] = nums[deque.peek()];
            }
        }
        return ans;
    }
}