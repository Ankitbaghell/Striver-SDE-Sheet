class Solution {
    public void solve(int[] nums, int index, ArrayList<Integer> subAns, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(subAns));
        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) // leave the duplicate element
                continue;
            subAns.add(nums[i]);
            solve(nums, i + 1, subAns, ans);
            subAns.remove(subAns.size() - 1); // backtrack
        }

    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums); // sort the array so that all duplicates come together
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subAns = new ArrayList<>();

        solve(nums, 0, subAns, ans);
        return ans;
    }
}