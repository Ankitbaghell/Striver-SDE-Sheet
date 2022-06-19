class Solution {
    // boolean solve(String s, int index, List<String> wordDict, int[] dp ){
    // if(index == s.length()){
    // return true;
    // }

    // if(dp[index] != -1) return dp[index] == 1 ? true : false;

    // for(int i=index; i<s.length(); i++){
    // String left = s.substring(index, i+1);
    // if(wordDict.contains(left)){
    // // String right = s.substring(i+1);
    // boolean ans = solve(s, i+1, wordDict, dp);
    // dp[index] = ans? 1 : 0;
    // if(ans)
    // return true;
    // }
    // }
    // return false;
    // }

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        // Arrays.fill(dp,-1);
        // return solve(s, 0, wordDict,dp);
        dp[0] = true;

        for (int len = 1; len <= s.length(); len++) {
            for (int i = 0; i < len; i++) {
                String left = s.substring(i, len);
                if (wordDict.contains(left) && dp[i]) {
                    dp[len] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}