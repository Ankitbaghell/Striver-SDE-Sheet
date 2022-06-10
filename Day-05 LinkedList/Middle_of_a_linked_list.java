class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode fast = head , slow = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next;
            if(fast.next != null) 
              fast = fast.next;
        }
        return slow;
    }
}