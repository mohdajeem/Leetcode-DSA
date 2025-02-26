class LRUCache {
    class Node {
    int key;
    int val;
    Node next;
    Node prev;
    public Node(int key, int val){
        this.key=key;
        this.val = val;
        this.next = null;
        this.prev = null;
    }
    }
    

    HashMap<Integer, Node> map = new HashMap<>();
    Node head,tail;
    int size;
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        head = new Node(-1,-1);
        tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
            Node nd = map.get(key);
            int val = nd.val;
            deleteNode(nd);
            insertAtHead(nd);
            return val;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node nd = map.get(key);
            nd.val = value;
            deleteNode(nd);
            insertAtHead(nd);
        } else{
            size++;
            if(size > capacity){
                deleteLast();
                size--;
            }
            Node nd = new Node(key, value);
            insertAtHead(nd);
            map.put(key, nd);
        }
    }
    public void insertAtHead(Node nd){
        nd.next = head.next;
        head.next.prev = nd;
        nd.prev = head;
        head.next = nd;
    }
    public void deleteNode(Node nd){
        nd.prev.next = nd.next;
        nd.next.prev = nd.prev;
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