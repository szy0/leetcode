import java.util.*;
// tail means most  recently used <key, node>
// head means least recently used <key, node>
class LRUCache {
    private Map<Integer, ListNode> map; // <key, node of value>
    private int capacity;
    private ListNode tail;
    private ListNode head;
    
    static class ListNode {
        int key;
        int val;
        ListNode prev;
        ListNode next;
        ListNode(int key, int val) {
            this.key = key;
            this.val = val;
            prev = null;
            next = null;
        }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }
    
    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        else {
            int val = map.get(key).val;
            updateTail(key);
            return val;
        }
    }
    
    public void put(int key, int value) {
        if (!map.containsKey(key)) {
            map.put(key, new ListNode(key, value));
            if (map.size() == 1) {
                head = map.get(key);
                tail = map.get(key);
            } else { // simply adding tail
                tail.next = map.get(key);
                map.get(key).prev = tail;
                tail = tail.next;
                tail.next = null;
            }
            // simply removing head
            if (map.size() > this.capacity) {
                int keyLRU = head.key; // this is why we need the key property in the listNode
                head = head.next;
                head.prev = null;
                map.remove(keyLRU);
            }

        } else {
            map.get(key).val = value;
            updateTail(key);
        }
    }

    public void updateTail(int key) {
         // when this node is already tail, nothing needed to do 
        if (tail == map.get(key)) return;

        // when this node is the head
        if (head == map.get(key)) {
            tail.next = head;
            head.prev = tail;
           
            head = head.next;
            head.prev = null;

            tail = tail.next;
            tail.next = null;
           
        } else {
            // when this node is in the middle of linked list
            ListNode tmp = map.get(key);
 
           // tmp.prev is missing
            tmp.prev.next = tmp.next;
            tmp.next.prev = tmp.prev;
    
            tail.next = tmp;
            tmp.prev = tail;
            tail = tmp;
            tail.next = null;
        }
         
        // printCache();
        // printReversedCache();
    }


    // public void printCache() {
    //     ListNode tmp = head;
    //     System.out.println(".............");
    //     while(tmp != null) {
    //         System.out.println("key: " + tmp.key + "| value: " + tmp.val);
    //         tmp = tmp.next;
    //     }
    //     System.out.println(".............");
    // }

    // public void printReversedCache() {
    //     ListNode tmp = tail;
    //     System.out.println("R.............");
    //     while(tmp != null) {
    //         System.out.println("key: " + tmp.key + "| value: " + tmp.val);
    //         tmp = tmp.prev;
    //     }
    //     System.out.println("R.............");
    // }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */