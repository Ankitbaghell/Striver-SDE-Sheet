class Solution {
    boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    void solve(String s, int index, List<String> subAns, List<List<String>> ans) {
        if (index == s.length()) { // base case
            ans.add(new ArrayList<>(subAns));
            return;
        }

        for (int i = index; i < s.length(); i++) { // can put partition anywhere
            if (isPalindrome(s, index, i)) { // if palindrome then valid partition
                subAns.add(s.substring(index, i + 1));
                solve(s, i + 1, subAns, ans);
                subAns.remove(subAns.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> subAns = new ArrayList<>();
        solve(s, 0, subAns, ans);
        return ans;
    }
}