public class LRUCache {
    Map<Integer,Node> map;
    Node front;
    Node back;
    int capacity;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        front = new Node(-1, -1);
        back = new Node(-1, -1);
        front.next = back;
        back.prev = front;
    }

    public int get(int key) {
        int val = -1;
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
            addAtBack(back, node);
            val = node.data.v;
        }
        return val;

    }

    private void addAtBack(Node back, Node nodeToBeAdded) {
        nodeToBeAdded.prev = back.prev;
        nodeToBeAdded.next = back;
        back.prev.next = nodeToBeAdded;
        back.prev = nodeToBeAdded;
        map.put(nodeToBeAdded.data.k, nodeToBeAdded);
    }

    private void deleteNode(Node node) {
        map.remove(node.data.k);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            deleteNode(node);
        }
        if (map.size() == capacity) {
            deleteNode(front.next);
        }
        Node newEntry = new Node(key, value);
        addAtBack(back, newEntry);
    }
}

class Data{
    int k;
    int v;
    Data(int k, int v){
        this.k = k;
        this.v = v;
    }
}

class Node {
    Node prev;
    Node next;
    Data data;

    Node(int k, int v){
        this.data = new Data(k,v);
        this.prev = null;
        this.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */