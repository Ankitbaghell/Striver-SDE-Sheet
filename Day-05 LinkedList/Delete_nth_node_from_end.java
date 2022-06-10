class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode start = new ListNode(0); // dummy node
        start.next = head;
        ListNode slow = start, fast = start;

        // Move fast in front so that the gap between slow and fast becomes n
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        // Move fast and slow by one steps till fast reach the last node
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        // delete the node
        slow.next = slow.next.next;
        return start.next;
    }
}