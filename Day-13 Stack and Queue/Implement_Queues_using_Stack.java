class MyQueue {
    Stack<Integer> st1;
    Stack<Integer> st2;

    public MyQueue() {
        st1 = new Stack<>();
        st2 = new Stack<>();
    }

    public void push(int x) {
        st1.push(x);
    }

    public int pop() {
        if (st1.empty())
            return -1;

        while (!st1.empty()) {
            st2.push(st1.pop());
        }
        int ans = st2.pop();

        while (!st2.empty()) {
            st1.push(st2.pop());
        }
        return ans;
    }

    public int peek() {
        if (st1.empty())
            return -1;

        while (!st1.empty()) {
            st2.push(st1.pop());
        }
        int ans = st2.peek();

        while (!st2.empty()) {
            st1.push(st2.pop());
        }
        return ans;
    }

    public boolean empty() {
        if (st1.empty())
            return true;
        return false;
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */