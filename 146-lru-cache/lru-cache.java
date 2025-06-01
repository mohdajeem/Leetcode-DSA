class Node{
    int key, val;
    Node next;
    Node prev;
    public Node(int key, int val){
        this.key = key;
        this.val = val;
    }
}

class LRUCache {
    HashMap<Integer, Node> map;
    int size;
    int capacity;
    Node tail, head;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        this.size = 0;
        this.capacity = capacity;
        tail = new Node(-1,-1);
        head = new Node(-1,-1);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        deleteNode(node);
        insertHead(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node nd = map.get(key);
            nd.val = value;
            deleteNode(nd);
            insertHead(nd);
        } else{
            size++;
            if(size > capacity){
                deleteLast();
                size--;
            }
            Node nd = new Node(key,value);
            map.put(key, nd);
            insertHead(nd);
        }
        
    }
    public void deleteNode(Node nd){
        nd.prev.next = nd.next;
        nd.next.prev = nd.prev;
    }
    public void insertHead(Node newNode){
        newNode.next = head.next;
        head.next.prev = newNode;
        newNode.prev = head;
        head.next = newNode;
    }   
    public void deleteLast(){
        map.remove(tail.prev.key);
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */