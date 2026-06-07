package practise.leetCode;

import java.util.*;

class LRUCache {

    class Node {
        Node prev;
        Node next;
        int key, value;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int cap;
    Node head;
    Node tail;

    HashMap<Integer, Node> map = new HashMap<>();

    public LRUCache(int capacity) {
        cap = capacity;

        head = new Node(-1, -1);
        tail = new Node(-1, -1);

        head.next = tail;
        tail.prev = head;
    }

    void addNode(Node temp) {
        temp.next = head.next;
        head.next.prev = temp;

        head.next = temp;
        temp.prev = head;

        map.put(temp.key, temp);

        if (map.size() > cap) {
            Node lru = tail.prev;
            map.remove(lru.key);
            deleteNode(lru);
        }
    }

    void deleteNode(Node temp) {
        temp.next.prev = temp.prev;
        temp.prev.next = temp.next;
    }

    public int get(int key) {
        if (map.containsKey(key)) {
            Node temp = map.get(key);
            int val = temp.value;

            deleteNode(temp);
            addNode(temp);

            return val;
        }
        return -1;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {

            Node temp = map.get(key);
            temp.value = value;

            deleteNode(temp);
            addNode(temp);
        } else {
            Node temp = new Node(key, value);
            addNode(temp);
        }
    }
}

public class LC146_LRU_Cache {

    public static void main(String[] args) {

        String[] operations = {
                "LRUCache", "put", "put", "get", "put",
                "get", "put", "get", "get", "get"
        };

        int[][] values = {
                {2},
                {1, 1},
                {2, 2},
                {1},
                {3, 3},
                {2},
                {4, 4},
                {1},
                {3},
                {4}
        };

        List<Object> output = new ArrayList<>();

        LRUCache cache = null;

        for (int i = 0; i < operations.length; i++) {

            switch (operations[i]) {

                case "LRUCache":
                    cache = new LRUCache(values[i][0]);
                    output.add("null");
                    break;

                case "put":
                    cache.put(values[i][0], values[i][1]);
                    output.add("null");
                    break;

                case "get":
                    output.add(cache.get(values[i][0]));
                    break;
            }
        }

        System.out.println(output);
    }
}