// try repested substring match question first leetcode 459

class Solution {
    public int repeatedStringMatch(String a, String b) {
        int count = 1;
        String original = a;

        while (a.length() < b.length()) { // making length of a greater or equal to b
            a = a + original;
            count++;
        }

        if (isSubstring(a, b))
            return count;
        else if (isSubstring(a + original, b)) // we can use indexOf() to check subString or not
            return count + 1;
        return -1;
    }

    boolean isSubstring(String a, String b) { // same function as of leetcode 459
        int n = a.length();
        int m = b.length();
        for (int i = 0; i <= n - m; i++) {
            boolean isMatched = true;
            for (int j = 0; j < m; j++) {
                if (a.charAt(i + j) != b.charAt(j)) {
                    isMatched = false;
                    break;
                }
            }
            if (isMatched)
                return true;
        }
        return false;
    }
}