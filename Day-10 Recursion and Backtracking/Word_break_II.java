class Solution {

    void solve(String s, int index, List<String> wordDict, String subAns, List<String> ans) {
        if (index == s.length()) {
            subAns = subAns.substring(0, subAns.length() - 1);
            ans.add(subAns);
            return;
        }

        for (int i = index; i < s.length(); i++) {
            String left = s.substring(index, i + 1);
            if (wordDict.contains(left)) {
                String str = subAns;
                subAns = subAns + left + " ";
                solve(s, i + 1, wordDict, subAns, ans);
                subAns = str;
            }
        }

    }

    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> ans = new ArrayList<>();
        solve(s, 0, wordDict, "", ans);
        return ans;
    }
}