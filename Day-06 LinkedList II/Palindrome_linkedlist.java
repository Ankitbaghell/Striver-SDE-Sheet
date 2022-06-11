class Solution {
    public ListNode middleLL(ListNode head){
        ListNode fast = head , slow = head;
        while(fast.next!=null){
            slow = slow.next;
            fast= fast.next;
            if(fast.next!=null) fast = fast.next;
        }
        return slow;
    }
    
    public ListNode reverseLL(ListNode middle){
        ListNode p  = middle , q= null , r=null;
            while(p!=null){
                r=q;
                q=p;
                p=p.next;
                q.next=r;
            }
        return q;
    }
    
    public boolean isPalindrome(ListNode head) {
        if(head.next == null) return true;
        
        ListNode p = head;
        ListNode middle = middleLL(head);    // find middle element
        
        // reverse the list from middle to end
        middle = reverseLL(middle);
        
        //compare elements of both halves
        while(middle!=null){
            if(p.val != middle.val) return false;
            p = p.next;
            middle = middle.next;
        }
     return true;
    }
}