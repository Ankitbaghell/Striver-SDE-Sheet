class Solution {
    public int myAtoi(String s) {
        int ans = 0;
        boolean negative = false;

        int i = 0;
        while (i < s.length() && s.charAt(i) == ' ') // whitespace remove
            i++;

        if (i < s.length() && s.charAt(i) == '-') {
            negative = true;
            i++;
        } else if (i < s.length() && s.charAt(i) == '+') {
            i++;
        }

        while (i < s.length() && (s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
            int digit = s.charAt(i) - '0';
            if (((Integer.MAX_VALUE - digit)) / 10 < ans) { // if goes out of bound
                if (negative)
                    return Integer.MIN_VALUE;
                else
                    return Integer.MAX_VALUE;
            }
            ans = ans * 10 + digit;
            i++;
        }

        // if(ans == 0)
        // return 0;
        if (negative)
            return -ans;
        else
            return ans;

    }
}