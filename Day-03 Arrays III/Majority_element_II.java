import java.util.*;

class Solution {
    boolean greaterFreq(int[] nums, int val) {
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val)
                count++;
        }
        return count > nums.length / 3; // according to question
    }

    public List<Integer> majorityElement(int[] nums) {
        ArrayList<Integer> ans = new ArrayList<>();
        int val1 = nums[0];
        int count1 = 1;
        int val2 = nums[0]; // we can take any value
        int count2 = 0; // in starting it has to be 0

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == val1)
                count1++;
            else if (nums[i] == val2)
                count2++;
            else {
                if (count1 == 0) { // if not available for mapping
                    val1 = nums[i];
                    count1 = 1;
                } else if (count2 == 0) { // if not available for mapping
                    val2 = nums[i];
                    count2 = 1;
                } else {
                    count1--; // mapped
                    count2--;
                }
            }
        }

        // now val1 and val2 are potential candidate , to confirm check the frequency
        if (greaterFreq(nums, val1))
            ans.add(val1);
        if (val1 != val2 && greaterFreq(nums, val2)) // to remove duplicate addition
            ans.add(val2);

        return ans;
    }
}