package tao.algorithm.medium;


/**
 * @description：LRU 缓存
 * @author： tao
 * @create： 2024/1/22 16:37
 */
public class Solution34 {

    int length;
    int num;
    Node head;
    Node last;

    public Solution34(int capacity) {
        this.length = capacity;
        this.num = 0;
    }

    public static void main(String[] args) {
        Solution34 so = new Solution34(5);
        so.put(1,2);
        so.get(1);
    }
    public int get(int key) {
        if (length == 0 || num == 0) return -1;

        Node cur = head;
        while (cur != null) {
            if (cur.getKey() == key) {
                put(key, cur.value);
                return cur.getValue();
            }
            cur = cur.next;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (length == 0) return;
        Node node = new Node(key, value, last, null);
        if (num == 0){
            head = node;
            last = node;
            num++;
            return;
        }
        if(num ==1){
           if (head.key == key){
               head.value = value;
           }
        }
        Node cur = head;
        while (cur != null) {
            if (cur.getKey() == key) {
                cur.setValue(value);
                if (cur.pre != null) {
                    cur.pre.next = cur.next;
                }
                if (cur.next != null) {
                    cur.next.pre = cur.pre;
                }
                last.next = cur;
                cur.pre = last;
                cur.next = null;
                last = cur;
                return;
            }
            System.out.println("xac");
        }
        last.next = node;
        last = node;
        if (num < length) {
            num++;
        } else {
            head.next.pre = null;
            head = head.next;
        }
    }

    class Node {
        int key;
        int value;
        Node next;
        Node pre;

        public Node(int key, int value, Node pre, Node next) {
            this.key = key;
            this.value = value;
            this.pre = pre;
            this.next = next;
        }

        public int getKey() {
            return key;
        }

        public void setKey(int key) {
            this.key = key;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }

        public Node getPre() {
            return pre;
        }

        public void setPre(Node pre) {
            this.pre = pre;
        }
    }
}


/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
