class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 1;
        int start = 0, end = 0;

        // for odd length palindrome
        for (int i = 0; i < n; i++) {
            int l = i, r = i;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            int len = r - l - 1;
            if (len > maxLength) {
                maxLength = len;
                start = l + 1;
                end = r - 1;
            }
        }

        // for even length palindrome
        for (int i = 0; i < n; i++) {
            int l = i, r = i + 1;
            while (l >= 0 && r < n && s.charAt(l) == s.charAt(r)) {
                l--;
                r++;
            }

            int len = r - l - 1;
            if (len > maxLength) {
                maxLength = len;
                start = l + 1;
                end = r - 1;
            }
        }

        return s.substring(start, end + 1);
    }
}