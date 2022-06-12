
class Solution {
    public Node copyRandomList(Node head) {

        // step 1 : create a clone list by next pointer only
        Node temp = head;
        Node cloneHead = null, cloneTail = null;

        while (temp != null) {
            Node newNode = new Node(temp.val);
            if (cloneHead == null) {
                cloneHead = cloneTail = newNode;
            } else {
                cloneTail.next = newNode;
                cloneTail = cloneTail.next;
            }
            temp = temp.next;
        }

        // step 2 : clone nodes add in between original Lists
        temp = head;
        Node chead = cloneHead;
        while (temp != null) {
            Node nextNode = temp.next;
            temp.next = chead;
            temp = nextNode;

            nextNode = chead.next;
            chead.next = temp;
            chead = nextNode;
        }

        // step 3 : set the random pointers (traverse over original list)
        temp = head;
        while (temp != null) {
            if (temp.next != null) {
                if (temp.random != null)
                    temp.next.random = temp.random.next;
                else
                    temp.next.random = null;
            }
            temp = temp.next.next;
        }

        // step 4 : Revert the changes done in step 2
        temp = head;
        chead = cloneHead;
        while (chead != null) {
            Node nextNode = temp.next.next;
            temp.next = nextNode;
            temp = temp.next;
            if (temp != null) {
                nextNode = temp.next;
                chead.next = nextNode;
                chead = chead.next;
            } else {
                chead.next = null;
                chead = chead.next;
            }
        }

        // step 5 : return the answer
        return cloneHead;
    }
}