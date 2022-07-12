class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        int m = haystack.length();

        for (int i = 0; i <= (m - n); i++) { // traversing over big string
            boolean isMatched = true;
            for (int j = 0; j < n; j++) { // traversing over small string
                if (haystack.charAt(j + i) != needle.charAt(j)) {
                    isMatched = false;
                    break;
                }
            }

            if (isMatched == true)
                return i;
        }

        return -1;

    }
}