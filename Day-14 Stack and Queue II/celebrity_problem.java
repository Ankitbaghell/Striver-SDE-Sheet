
class Solution {

    int celebrity(int M[][], int n) {
        // Step 1 : put all element in stack
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            st.push(i);
        }

        // step 2 : while size > 1 pop two element and check knowns
        while (st.size() > 1) {
            int a = st.pop();
            int b = st.pop();

            if (M[a][b] == 1)
                st.push(b);
            else
                st.push(a);

        }

        // step 3 : last elemety of stack can be the celebeity and now verify it
        int last = st.pop();

        // row check ---> all 0s
        for (int i = 0; i < n; i++) {
            if (M[last][i] == 1)
                return -1;
        }

        // column check ---> all 1s except diagonal
        for (int i = 0; i < n; i++) {
            if (last != i && M[i][last] == 0)
                return -1;
        }

        return last;
    }
}