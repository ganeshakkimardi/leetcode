package practise.src.main.java.leetCode;

import java.util.HashMap;
import java.util.Map;

public class LC138_CopyListWithRandomPointer {

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    // Helper method to build the list from input
    public static Node buildList(int[][] input) {
        Node[] nodes = new Node[input.length];

        // Create nodes
        for (int i = 0; i < input.length; i++) {
            nodes[i] = new Node(input[i][0]);
        }

        // Set next pointers
        for (int i = 0; i < nodes.length - 1; i++) {
            nodes[i].next = nodes[i + 1];
        }

        // Set random pointers
        for (int i = 0; i < input.length; i++) {
            int randomIndex = input[i][1];
            if (randomIndex != -1) {
                nodes[i].random = nodes[randomIndex];
            }
        }

        return nodes[0];
    }

    public static Node copyRandomList(Node head) {
        Node cur = head;
        HashMap<Node, Node> map = new HashMap<>();
        while(cur != null) {
            map.put(cur, new Node(cur.val));
            cur = cur.next;
        }
        cur = head;
        while(cur != null) {
            Node copy = map.get(cur);
            copy.next = map.get(cur.next);
            copy.random = map.get(cur.random);
            cur = cur.next;
        }
        return map.get(head);
    }

    public static void main(String[] args) {
        // Input: [[7,null],[13,0],[11,4],[10,2],[1,0]]
        // Using -1 to represent null
        int[][] input = {
                {7, -1},
                {13, 0},
                {11, 4},
                {10, 2},
                {1, 0}
        };

        Node head = buildList(input);
        System.out.println("Original array:: ");
        printList(head);
        Node copiedHead = copyRandomList(head);
        System.out.println("Copied array:: ");
        printList(copiedHead);
    }

    public static void printList(Node head) {
        Map<Node, Integer> indexMap = new HashMap<>();
        Node curr = head;
        int index = 0;

        // First pass: store index of each node
        while (curr != null) {
            indexMap.put(curr, index++);
            curr = curr.next;
        }

        // Second pass: print nodes
        curr = head;
        while (curr != null) {
            int val = curr.val;
            String randomIndex = (curr.random == null)
                    ? "null"
                    : String.valueOf(indexMap.get(curr.random));

            System.out.print("[" + val + "," + randomIndex + "] ");
            curr = curr.next;
        }
        System.out.println();
    }
}
