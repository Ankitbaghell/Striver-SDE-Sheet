public class Solution {
    public static Node merge2LL(Node h1, Node h2) {
        if (h1 == null)
            return h2;
        if (h2 == null)
            return h1;
        Node p = h1, q = h2, newHead = null, tail = null;
        while (p != null && q != null) {
            if (p.data <= q.data) {
                if (newHead == null) {
                    newHead = tail = p;
                } else {
                    tail.child = p;
                    tail = tail.child;
                }
                p = p.child;
            } else {
                if (newHead == null) {
                    newHead = tail = q;
                } else {
                    tail.child = q;
                    tail = tail.child;
                }
                q = q.child;
            }
        }
        if (p != null)
            tail.child = p;
        else
            tail.child = q;
        return newHead;
    }

    public static Node flattenLinkedList(Node head) {
        // base case
        if (head == null || head.next == null)
            return head;

        Node down = head;

        // Remaining solve by recursion
        Node right = flattenLinkedList(head.next);
        down.next = null; // to break it in a seprate list
        Node result = merge2LL(down, right);
        return result;
    }
}
