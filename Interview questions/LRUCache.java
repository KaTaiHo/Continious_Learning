class LRUCache {

    private class Node {
            Node prev, next;
            int key, value;
    
            Node (int k, int v)
            {
                this.key = k;
                this.value = v;
            }
    
            Node()
            {
                this.key = 0;
                this.value = 0;
            }
        }
    
        int count, capacity;
        Node head;
        Node tail;
        HashMap<Integer, Node> map;
    
        public LRUCache(int capacity) {
            this.count = 0;
            this.capacity = capacity;
            this.head = new Node();
            this.tail = new Node();
            this.head.next = this.tail;
            this.tail.prev = this.head;
            map = new HashMap<>();
        }
        
        public int get(int key) {
            if (this.map.containsKey(key)) 
            {
                Node n = this.map.get(key);
                update(n);
    
                return n.value;
            }
            return -1;
        }
        
        public void put(int key, int value) {
            if (this.map.containsKey(key))
            {
                Node n = this.map.get(key);
                n.value = value;
                update(n);
            }
            else 
            {
                Node newNode = new Node(key, value);
                this.map.put(key, newNode);
                if (count >= capacity)
                {
                    this.map.remove(this.tail.prev.key);
                    removeNode(this.tail.prev);
                    this.count--;
                }
    
                addNode(newNode);
                this.count++;
            }
        }
    
        private void update (Node n)
        {
            removeNode(n);
            addNode(n);
        }
    
        private void addNode (Node n)
        {
            n.next = this.head.next;
            n.next.prev = n;
            this.head.next = n;
            n.prev = this.head;
        }
    
        private void removeNode (Node n)
        {
            Node before = n.prev;
            Node after = n.next;
            before.next = after;
            after.prev = before;
        }
    }
    
    /**
     * Your LRUCache object will be instantiated and called as such:
     * LRUCache obj = new LRUCache(capacity);
     * int param_1 = obj.get(key);
     * obj.put(key,value);
     */