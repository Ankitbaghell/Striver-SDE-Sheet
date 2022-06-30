
class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;

    public MedianFinder() {
        left = new PriorityQueue<>(Collections.reverseOrder()); // max pq
        right = new PriorityQueue<>(); // min pq
    }

    public void addNum(int num) {
        if (right.size() > 0 && num > right.peek()) {
            right.add(num);
        } else {
            left.add(num);
        }

        // maintain the balancing
        if (left.size() - right.size() == 2) {
            right.add(left.remove());
        } else if (right.size() - left.size() == 2) {
            left.add(right.remove());
        }
    }

    public double findMedian() {
        if (left.size() > right.size())
            return left.peek();
        if (right.size() > left.size())
            return right.peek();
        else if (left.size() == right.size())
            return (left.peek() + right.peek()) / 2.0;
        return -1;
    }
}
