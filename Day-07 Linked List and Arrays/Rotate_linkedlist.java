// if k is greater than length of LL then we have to do only (k % length) rotation , because after every k rotation we will get original list

class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        // base case
        if(head == null || head.next == null || k == 0) 
            return head;
        
        // find length of LL
        ListNode p = head;
        int length = 1;
        while(p.next != null){
            length++;
            p = p.next;
        }
        
        // now point the last node to the head node
        p.next = head;
        k = k % length;       //manipulating the k value according to the lenegth of LL
        k = length - k;
        
        while(k > 0){        // go till (length - k) th node
            p = p.next;
            k--;
        }
        
        // change the head and then break the link
        head = p.next;
        p.next = null;
        
        return head;
        
    }
}