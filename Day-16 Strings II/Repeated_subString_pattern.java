class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = n / 2; i >= 1; i--) {
            if (n % i == 0) {
                int j = 0;
                while (j + i < n && s.charAt(j) == s.charAt(j + i))
                    j++;
                if (j + i == n)
                    return true;
            }
        }
        return false;
    }
}