
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;

        // sort the array
        Arrays.sort(nums);

        for (int i = 0; i <= n - 3; i++) { // peeche ke do nhi lena (triplet nhi ho paega)
            if (i != 0 && nums[i] == nums[i - 1]) // to remove duplicates
                continue;

            // else finding the pairs
            int start = i + 1, end = n - 1;
            int newTarget = 0 - nums[i]; // required Sum
            while (start < end) {
                int sum = nums[start] + nums[end];
                if (sum == newTarget) { // Tripletv mil gaya hai
                    ArrayList<Integer> subAns = new ArrayList<>();
                    subAns.add(nums[i]);
                    subAns.add(nums[start]);
                    subAns.add(nums[end]);
                    ans.add(subAns);

                    while (start < end && nums[start] == nums[start + 1])
                        start++; // to remove duplicates
                    while (start < end && nums[end] == nums[end - 1])
                        end--;
                    start++;
                    end--;
                } else if (sum > newTarget)
                    end--;
                else
                    start++;
            }
        }
        return ans;
    }
}