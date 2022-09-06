class LRUCache {
    //We are going to need to have something more than just a HashMap here.
    //We need to also keep track of order somehow, with a LinkedList! (deletion and 
    //insertion are both O(1) operations)
    
    //Dummy nodes for the head and tail
    Node head = new Node();
    Node tail = new Node();
    
    //HashMap for the Nodes and a capacity
    Map<Integer, Node> nodeMap;
    int capacity;

    //Setting up the HashMap and the LinkedList
    public LRUCache(int capacity) {
        this.capacity = capacity;
        nodeMap = new HashMap();
        head.next = tail;
        tail.prev = head;
    }
    
    //Get method, check if its valid, if it isn't return -1
    //if it is then remove it and then append it to the front to make it
    //mean that it's been most recently accessed
    public int get(int key) {
        Node nodeToGet = nodeMap.get(key);
        if(nodeToGet == null) {
            return -1;
        }
        remove(nodeToGet);
        add(nodeToGet);
        return nodeToGet.val;
    }
    
    //Check if its already a valid value first, and if it is just update it
    //Otherwise, if its a new Node, check if you're at capacity. If you are
    //remove the tail (tail is a dummy so remove the previous) as well as from the LinkedList
    //Add in the new Node to the map and LinkedList
    public void put(int key, int value) {
        Node nodeToGet = nodeMap.get(key);
        if(nodeToGet != null) {
            nodeToGet.val = value;
            remove(nodeToGet);
            add(nodeToGet);
        }
        else {
            if(nodeMap.size() == capacity) {
                nodeMap.remove(tail.prev.key);
                remove(tail.prev);
            }
            Node toAdd = new Node();
            toAdd.key = key;
            toAdd.val = value;
            nodeMap.put(key,toAdd);
            add(toAdd);
        }
    }
    //Adding an element to the head of a LinkedList
    public void add(Node node) {
        Node headnext = head.next;
        node.next = headnext;
        headnext.prev = node;
        head.next = node;
        node.prev = head;
    }
    //Removing an element from the end of a LinkedList
    public void remove(Node node) {
        Node next = node.next;
        Node prev = node.prev;
        
        next.prev = prev;
        prev.next = next;
    }
}

//Node class
class Node {
    int key;
    int val;
    Node next;
    Node prev;
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

//Using LinkedList Object.

// class LRUCache {
    
//     LinkedList<Integer> orderList;
//     Map<Integer, Integer> lister;
//     int capacity;
    
//     public LRUCache(int capacity) {
//         orderList = new LinkedList();
//         lister = new HashMap();
//         this.capacity = capacity;
//     }
    
//     public int get(int key) {
//         if(lister.get(key) == null) {
//             return -1;
//         }
//         else {
//             orderList.remove(new Integer(key));
//             orderList.addFirst(key);
//             return lister.get(key);
//         }
//     }
    
//     public void put(int key, int value) {
//         if(lister.get(key) != null) {
//             lister.put(key, value);
//             orderList.remove(new Integer(key));
//             orderList.addFirst(key);
//         }
//         else {
//             if(capacity == lister.size()) {
//                 int keyToRemove = orderList.removeLast();
//                 lister.remove(keyToRemove);
//             }
//             lister.put(key, value);
//             orderList.addFirst(key);
//         }
//     }
// }
