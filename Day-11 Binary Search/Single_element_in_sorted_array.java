class Solution {
    public int singleNonDuplicate(int[] nums) {
        int start = 0;
        int end = nums.length - 2;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (nums[mid] == nums[mid ^ 1]) // left half
                start = mid + 1;
            else
                end = mid - 1; // right half
        }
        return nums[start];
    }
}