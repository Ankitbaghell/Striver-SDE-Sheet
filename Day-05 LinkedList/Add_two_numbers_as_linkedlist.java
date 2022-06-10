
class Solution {
    public ListNode addTwoNumbers(ListNode head1, ListNode head2) {
        ListNode newHead = null, tail = null;
        ListNode p = head1, q = head2;
        int carry = 0;

        while (p != null || q != null || carry != 0) {
            int val1 = 0;
            int val2 = 0;
            if (p != null)
                val1 = p.val;
            if (q != null)
                val2 = q.val;

            int sum = val1 + val2 + carry;
            carry = sum / 10;
            ListNode newNode = new ListNode(sum % 10);
            if (newHead == null)
                newHead = tail = newNode;
            else {
                tail.next = newNode;
                tail = tail.next;
            }

            if (p != null)
                p = p.next;

            if (q != null)
                q = q.next;
        }
        return newHead;
    }
}