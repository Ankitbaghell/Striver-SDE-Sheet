class MyStack {

    Queue<Integer> q;

    public MyStack() {
        q = new LinkedList<>();
    }

    public void push(int x) {
        q.add(x);
    }

    public int pop() {
        if (q.isEmpty())
            return -1;
        int s = q.size();
        while (s != 1) { // removing element from Queue and also adding at end of queue
            q.add(q.remove());
            s--;
        }
        return q.remove();
    }

    public int top() {
        if (q.isEmpty())
            return -1;

        int s = q.size();
        while (s != 1) {
            q.add(q.remove());
            s--;
        }
        int x = q.remove();
        q.add(x);
        return x;
    }

    public boolean empty() {
        if (q.isEmpty())
            return true;
        return false;
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */