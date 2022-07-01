class Solution {
    public boolean isValid(String s) {

        // we have to use stack
        Stack<Character> st = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                st.push(s.charAt(i));
            } else {
                if ((s.charAt(i) == ')' && !st.empty() && st.peek() == '(')
                        || (s.charAt(i) == ']' && !st.empty() && st.peek() == '[') ||
                        (s.charAt(i) == '}' && !st.empty() && st.peek() == '{')) {
                    st.pop();
                } else
                    return false;
            }
        }
        if (st.empty())
            return true;

        return false;
    }
}