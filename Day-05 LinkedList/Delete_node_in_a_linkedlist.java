// to do this ==> just copy the next node's value and then remove that next node ;-)
class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}