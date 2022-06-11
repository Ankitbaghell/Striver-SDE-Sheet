public class Solution {

    public ListNode hasCycle(ListNode head) {
        if (head == null || head.next == null)
            return null;
        ListNode fast = head, slow = head;
        do {
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        } while (fast != null && fast != slow);

        if (fast == slow)
            return fast;
        return null;
    }

    public ListNode detectCycle(ListNode head) {

        // step 1 : call hasCycle method to check cycle is there or not
        ListNode fast = hasCycle(head);
        if (fast == null)
            return null;

        // step 2 : means Cycle is present , so set slow = head and move
        // both pointer with same pace
        ListNode slow = head;

        while (fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;

    }
}