import java.util.*;
import java.io.*;

public class Solution {
    static ArrayList<Integer> nextSmallerElement(ArrayList<Integer> arr, int n) {

        ArrayList<Integer> res = new ArrayList<>(n);
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        // traversing from right to left
        for (int i = n - 1; i >= 0; i--) {
            int curr = arr.get(i);
            while (st.peek() >= curr) {
                st.pop();
            }
            // now top of the stack is our answer
            res.add(st.peek());
            st.push(curr);
        }
        Collections.reverse(res);
        return res;
    }
}