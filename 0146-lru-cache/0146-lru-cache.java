class LRUCache {
    int limit = 0;
    Node start = null, end = null;
    HashMap<Integer, Node> map = null;
    public LRUCache(int capacity) {
        map = new HashMap<>();
        limit = capacity;
        start = new Node(-1,-1);
        end = new Node(-1,-1);
        start.next = end;
        end.prev = start;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;
        Node node = map.get(key);
        Node newNode = new Node(node.k, node.v);
        delete(node);
        add(newNode);
        return newNode.v;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)) {
            Node node = map.get(key);
            delete(node);
        }
        Node newNode = new Node(key, value);
        if(map.size() == limit){
            delete(end.prev);
        }
        add(newNode);
        
    }

    void delete(Node node){
        map.remove(node.k);
        Node prevNd = node.prev;
        Node nextNd = node.next;

        prevNd.next = nextNd;
        nextNd.prev = prevNd;
    }
    void add(Node node){
        start.next.prev = node;
        node.next = start.next;
        node.prev = start;
        start.next = node;
        map.put(node.k, node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */

class Node{
    Node prev;
    Node next;
    int k;
    int v; 

    Node(int k, int v){
        this.k = k;
        this.v = v;
    }
} 