
class Solution {
    public int validCandidate(int[] nums) {
        int val = nums[0];
        int count = 1;

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == val)
                count++; // same element increment the freq
            else
                count--; // differnet element map it with val

            if (count == 0) {
                val = nums[i];
                count = 1;
            }
        }
        return val; // it is the potential candidate
    }

    public int majorityElement(int[] nums) {
        int maxEle = validCandidate(nums);
        int freq = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == maxEle)
                freq++;
        }

        if (freq > nums.length / 2)
            return maxEle; // majority element
        else
            return -1; // no majority exists
    }
}