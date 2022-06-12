class Solution {
    public int removeDuplicates(int[] nums) { // 2 pointer approch

        for (int i = 0; i < nums.length;) {
            int j = i + 1;
            while (j < nums.length && nums[i] == nums[j]) {
                nums[j++] = -101; /// because -101 is out of range
            }
            i = j;
        }

        int k = 0;
        for (int i = 1; i < nums.length; i++) { // putting -101 on other sides
            if (nums[i] == -101) {
                int j = i + 1;
                while (j < nums.length && nums[j] == -101)
                    j++;
                if (j == nums.length)
                    break;

                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                k++; // counting valid numbers
            } else
                k++;
        }

        // OR
        // int k = 0;
        // for(int i=0; i<nums.length; i++){ // counting valid numbers
        // if(nums[i] != -101)
        // k++;
        // }

        return k + 1;
    }
}