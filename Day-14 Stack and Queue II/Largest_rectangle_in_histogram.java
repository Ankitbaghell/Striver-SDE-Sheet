class Solution {

    // function to find Indices of next Smaller elements
    public int[] nextSmallerElement(int[] heights, int n) {

        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = n - 1; i >= 0; i--) {
            while ((st.peek() != -1) && heights[st.peek()] >= heights[i])
                st.pop();
            ans[i] = st.peek();
            st.push(i); // working on indices
        }
        return ans;
    }

    // function to find Indices of previous Smaller elements
    public int[] prevSmallerElement(int[] heights, int n) {

        int[] ans = new int[n];
        Stack<Integer> st = new Stack<>();
        st.push(-1);

        for (int i = 0; i < n; i++) {
            while ((st.peek() != -1) && heights[st.peek()] >= heights[i])
                st.pop();
            ans[i] = st.peek(); // working on indices
            st.push(i);
        }
        return ans;
    }

    public int largestRectangleArea(int[] heights) {
        int n = heights.length;

        // array to store Indices of next Smaller elements
        int[] nextSmaller = new int[n];
        nextSmaller = nextSmallerElement(heights, n);

        // array to store Indices of previous Smaller elements
        int[] prevSmaller = new int[n];
        prevSmaller = prevSmallerElement(heights, n);

        int area = Integer.MIN_VALUE;

        // traversing over heights array
        for (int i = 0; i < n; i++) {
            int length = heights[i]; // length of rectangle

            if (nextSmaller[i] == -1) { // when all the bars have same height
                nextSmaller[i] = n;
            }

            int breadth = nextSmaller[i] - prevSmaller[i] - 1; // breadth of rect.

            int newArea = length * breadth;
            area = Math.max(area, newArea);
        }
        return area;
    }
}