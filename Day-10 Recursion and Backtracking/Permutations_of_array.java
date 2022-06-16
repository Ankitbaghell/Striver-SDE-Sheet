class Solution {

    void solve(ArrayList<Integer> arr, int index, List<List<Integer>> ans) {
        // base case
        if (index == arr.size()) {
            ans.add(new ArrayList<>(arr));
            return;
        }

        // from index to j we are traversing and swapping elements
        for (int j = index; j < arr.size(); j++) {
            Collections.swap(arr, j, index);
            solve(arr, index + 1, ans);
            Collections.swap(arr, j, index); // backtracking purpose
        }

    }

    public List<List<Integer>> permute(int[] nums) {

        ArrayList<Integer> arr = new ArrayList<>();
        for (int x : nums) {
            arr.add(x);
        }

        List<List<Integer>> ans = new ArrayList<>();
        int index = 0;

        solve(arr, index, ans);
        return ans;

    }
}