class Solution {
    void solve(int[] arr,int index, int target, ArrayList<Integer> subAns, int sumOfSubAns, List<List<Integer>> ans){
        if(index >= arr.length || sumOfSubAns >= target){
            if(sumOfSubAns == target)
                ans.add(new ArrayList<>(subAns));    //required answer
            return;
        }
        
        solve(arr, index+1, target, subAns,sumOfSubAns, ans);    // not pick
        subAns.add(arr[index]);
        solve(arr, index, target, subAns,sumOfSubAns+arr[index], ans);   //pick and can pick again
        subAns.remove(subAns.size()-1);
    } 
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subAns = new ArrayList<>();
        solve(candidates, 0, target, subAns, 0, ans);
        return ans;
    }
}