
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();

        // Sort the array
        Arrays.sort(nums);
        int n = nums.length;

        for (int i = 0; i <= n - 4; i++) {
            if (i != 0 && nums[i] == nums[i - 1]) // ignoring duplicates
                continue;

            for (int j = i + 1; j <= n - 3; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) // ignoring duplicates
                    continue;

                int start = j + 1;
                int end = n - 1;
                int newTarget = target - nums[i] - nums[j];
                while (start < end) {
                    int sum = nums[start] + nums[end];
                    if (sum == newTarget) { // req Quad
                        ArrayList<Integer> subAns = new ArrayList<>();
                        subAns.add(nums[i]);
                        subAns.add(nums[j]);
                        subAns.add(nums[start]);
                        subAns.add(nums[end]);
                        ans.add(subAns);

                        while (start < end && nums[start] == nums[start + 1])
                            start++; // ignoring duplicates
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
        }
        return ans;
    }
}