// kadane's algo

class Solution {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int currSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currSum += nums[i];
            max = Math.max(max, currSum);
            if (currSum < 0) // bcz it will decrease the sum
                currSum = 0;
        }
        return max;
    }
}