package practise.leetCode;

public class LC141_Linked_List_Cycle {
//    class ListNode {
//        int val;
//        practise.src.main.java.leetCode.ListNode next;
//
//        ListNode() {}
//
//        ListNode(int val) {
//            this.val = val;
//            this.next = null;
//        }
//
//        ListNode(int val, practise.src.main.java.leetCode.ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }
    public static void main(String[] args) {

        // Create nodes
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // Link nodes: 3 -> 2 -> 0 -> -4
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        // Create a cycle: -4 -> 2
        node4.next = node2;

        boolean result = hasCycle(node1);

        System.out.println(result); // expected: true
    }

    public static boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while(slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }
        return false;
    }
}
