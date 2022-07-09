
class Node{       // DLL node
    int key, value;
    Node prev, next;
    
    public Node(){}
    public Node(int key, int value){
        this.key = key;
        this.value = value;
    }
} 

class LRUCache {
    
    // some self defined required functions
    
    private void addNode(Node node){      // add on First position after dummy node
        node.next = head.next;
        node.prev = head;
        
        head.next.prev = node;
        head.next = node;
    }
    
    private void removeNode(Node node){        // to remove node from DLL
        Node prevNode = node.prev;
        Node nextNode = node.next;
        
        prevNode.next = nextNode;
        nextNode.prev = prevNode;

        node.next = null;
        node.prev = null;
    }
    
    private void moveToFront(Node node){      // after access we have to move node to front
        removeNode(node);
        addNode(node);
    }
    
    
    // Data structures required
    
    HashMap<Integer,Node> cache;     //key - node
    int cap;
    Node head, tail;       // dummy DLL nodes
    
    public LRUCache(int capacity) {
        cache = new HashMap<>();
        cap = capacity;
        head = new Node();
        tail = new Node();
        
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null)           // doesn't exists in map
            return -1;
        else{                // exists in map
            int val = node.value;
            moveToFront(node);        // we used it so put in front
            return val;
        }
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node == null){         // pair doesn't exists
            Node newNode = new Node(key, value);
            if(cache.size() == cap){
                Node LRU_Node = tail.prev;      // least recent used node
                cache.remove(LRU_Node.key);     // remove from map
                removeNode(LRU_Node);           // remove from DLL
            }
            cache.put(key, newNode);      // add in map
            addNode(newNode);             // add in front of DLL   
        }
        else{
            node.value = value;
            moveToFront(node);     // make recently used
        }
    }
}
