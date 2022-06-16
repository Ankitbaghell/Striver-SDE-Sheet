class Solution {
    void solve(int[] candidates,int index, int target, ArrayList<Integer> subAns, List<List<Integer>> ans){
        if(target <= 0){
            if(target == 0)
            ans.add(new ArrayList<>(subAns));
            return;
        }
        
        for(int i=index; i<candidates.length; i++){      //from index to last , I can pick anyone 
            if(i!=index && candidates[i] == candidates[i-1])    // removing duplicates
                continue;
            subAns.add(candidates[i]);
            solve(candidates, i+1, target-candidates[i], subAns, ans);
            subAns.remove(subAns.size()-1);
        }
    }
    
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);     //so that all duplicates come together
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> subAns = new ArrayList<>();
        solve(candidates, 0, target, subAns, ans);
        return ans;
    }
}