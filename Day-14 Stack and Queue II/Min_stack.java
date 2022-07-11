class MinStack {

    Stack<Integer> st;   // stack to store actual values
    Stack<Integer> minSt;   // stack to store minimum values till that point
    int min = Integer.MAX_VALUE;
    public MinStack() {
        st = new Stack<>();
        minSt = new Stack<>();
    }
    
    public void push(int val) {
        st.push(val);
        min = Math.min(min, st.peek());
        minSt.push(min);
    }
    
    public void pop() {
        st.pop();
        minSt.pop();
        min = minSt.size() != 0 ? minSt.peek() : Integer.MAX_VALUE;
    }
    
    public int top() {
        return st.peek();
    }
    
    public int getMin() {
        return minSt.peek();
    }
}