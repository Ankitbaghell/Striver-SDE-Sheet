class Solution {
    public int longestOnes(int[] nums, int k) {
        int max = 0;
        int zerosCount = 0;
        int j = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                zerosCount++;

            while (zerosCount > k) {
                j++;
                if (nums[j] == 0)
                    zerosCount--;
            }

            int length = i - j;
            max = Math.max(max, length);
        }
        return max;
    }
}