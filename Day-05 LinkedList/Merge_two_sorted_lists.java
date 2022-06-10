class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;
        
        ListNode p = list1;
        ListNode q = list2;
        ListNode newHead = null ,tail = null;
        
        //Traverse over the LLs and compare the values
        while(p!=null && q!=null){
            
            if(p.val <= q.val){
                if(newHead != null){
                     tail.next = p;
                     tail = tail.next;
                }
                 else{                              // for first node
                     newHead = tail = p;
                 }
               p = p.next; 
            }
            
            else{
                if(newHead != null){
                     tail.next = q;
                     tail = tail.next;
                }
                 else{
                     newHead = tail = q;            // for first node
                 }
               q = q.next; 
            }
        }
        
            if(p==null) 
                tail.next = q;                      // at the end to add remaining nodes
            
            else  tail.next = p;
            
      return newHead;
    
    }
}