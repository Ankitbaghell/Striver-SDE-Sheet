class Pair {
    int span;
    int price;

    Pair(int s, int p) {
        span = s;
        price = p;
    }
}

class StockSpanner {
    Stack<Pair> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int count = 1;
        while (!st.empty() && st.peek().price <= price)
            count += st.pop().span;

        st.push(new Pair(count, price));
        return count;
    }
}
