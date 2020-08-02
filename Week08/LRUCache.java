import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    class CacheNode {
        private int key;

        private int value;

        private CacheNode prev;

        private CacheNode next;

        public CacheNode() {}

        public CacheNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Map<Integer, CacheNode> instance;

    private int size;
    private int capacity;
    private CacheNode head, tail;


    public LRUCache(int capacity) {
        instance = new HashMap<>(capacity);
        this.capacity = capacity;
        // 使用伪头部和伪尾部节点
        head = new CacheNode();
        tail = new CacheNode();
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        CacheNode node = instance.get(key);
        if (null == node) {
            return -1;
        }
        int value = node.value;
        moveToHead(node);
        return value;
    }

    public void put(int key, int value) {
        CacheNode node = instance.get(key);
        if (null == node) {
            size++;
            if(size > capacity) {
                CacheNode node1 = removeTail();
                instance.remove(node1.key);
                size--;
            }
            CacheNode newNode = new CacheNode(key, value);
            instance.put(key, newNode);
            addToHead(newNode);
            return;
        }
        node.value = value;
        moveToHead(node);
    }

    private void addToHead(CacheNode node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(CacheNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(CacheNode node) {
        removeNode(node);
        addToHead(node);
    }

    private CacheNode removeTail() {
        CacheNode res = tail.prev;
        removeNode(res);
        return res;
    }
}
