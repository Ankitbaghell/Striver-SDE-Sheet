class Solution {
    int lengthOfLL(ListNode head) {
        int count = 0;
        ListNode p = head;
        while (p != null) {
            count++;
            p = p.next;
        }
        return count;
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        // base case
        if (head == null || k == 1)
            return head;

        // creating a dummy node
        ListNode dummy = new ListNode();
        dummy.next = head;

        // using 3 pointers
        ListNode prev = dummy, curr = dummy, nex = dummy;

        // counting the length of LL
        int length = lengthOfLL(head);

        while (length >= k) {
            curr = prev.next;
            nex = curr.next;
            for (int i = 1; i < k; i++) { // reversing (k-1) links
                curr.next = nex.next;
                nex.next = prev.next;
                prev.next = nex;
                nex = curr.next;
            }
            prev = curr;
            length -= k; // k nodes are reversed
        }

        return dummy.next;
    }
}