class Node 
{
    int key; 
    int val; 
    Node next; 
    Node prev; 

    public Node(int key, int val)
    {
        this.key = key; 
        this.val = val; 
        this.prev = null; 
        this.next = null; 
    }
}

class LRUCache {
    Node left; 
    Node right; 
    Map<Integer, Node> map; 
    int capacity; 

    public LRUCache(int capacity) {
        map = new HashMap<>(); 
        this.capacity = capacity; 
        left = new Node(0, 0); 
        right = new Node(0, 0); 
        left.next = right; 
        right.prev = left; 
    }
    
    public int get(int key) {
        if (map.containsKey(key))
        {
            Node node = map.get(key); 
            remove(node); 
            insert(node); 
            return node.val; 
        }
        return -1; 
    }
    private void remove (Node node)
    {
        Node leftNeighbor = node.prev; 
        Node rightNeighbor = node.next; 
        leftNeighbor.next = rightNeighbor; 
        rightNeighbor.prev = leftNeighbor; 
    }

    private void insert(Node node)
    {
        Node leftNeighbor = right.prev; 
        leftNeighbor.next = node; 
        node.prev = leftNeighbor; 
        node.next = right; 
        right.prev = node; 
    }

    public void put(int key, int value) {
        if (map.containsKey(key))
        {
            Node node = map.get(key); 
            remove(node); 
        }

        Node newNode = new Node(key, value); 
        insert(newNode); 
        map.put(key, newNode); 

        if (map.size() > capacity)
        {
            Node remove = left.next; 
            map.remove(remove.key); 
            remove(remove); 
        }
        
    }
}
