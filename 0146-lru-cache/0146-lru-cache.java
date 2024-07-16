class LRUCache {
    HashMap<Integer, Node> map = null;
    Node head = null, tail = null;
    // head for new node , tail is for older
    int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(map.containsKey(key)) {
            Node old = map.get(key);
            Node newNode = new Node(old.k, old.v);
            remove(old);
            add(newNode);
            return newNode.v;
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if(map.size() == capacity){
            remove(tail.prev);
        }
        Node node = null;
        if(map.containsKey(key)) {
            remove(map.get(key));
        }
        Node newNode = new Node(key,value);
        add(newNode);
    }

    private void add(Node node){
        Node hn = head.next;
        node.prev = head;
        node.next = hn;
        hn.prev = node;
        head.next = node;
        map.put(node.k, node);
    }

    private void remove(Node node){
        Node np = node.prev;
        Node nn = node.next;
        np.next = nn;
        nn.prev = np;
        map.remove(node.k);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class Node{
    int k;
    int v;
    Node prev;
    Node next;

    public Node(int k, int v) {
        this.v = v;
        this.k = k;
        this.prev = this.next = null;
    }
}    