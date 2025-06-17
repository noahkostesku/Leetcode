class Node {
    int key;
    int val;
    Node prev;
    Node next;

    public Node(int key, int val) {
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    
    private int cap;
    private HashMap<Integer, Node> cache;
    private Node left;
    private Node right;

    public LRUCache(int capacity) {
        this.cap = capacity;
        this.cache = new HashMap<>();
        this.left = new Node(0, 0);
        this.right = new Node(0, 0);
        this.left.next = this.right;
        this.right.prev = this.left;
    }

    private void remove(Node node) {
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }

    //left is least recentry used, right is most recently used

    private void insert(Node node) {
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    public int get(int key) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            remove(node);
            insert(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int value) {
        //if key is already in cache, node already exitst in list with key-value pair so remove
        if (cache.containsKey(key)) {
            remove(cache.get(key));
        }
        //create a new node, put it in the hashmap, insert it as most recently used
        Node newNode = new Node(key, value);
        cache.put(key, newNode);
        insert(newNode);


        //have to check cap every time we insert
        if (cache.size() > cap) {
            //have to deleete least recently used referenced by left.next
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}


