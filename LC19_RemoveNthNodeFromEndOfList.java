package practise.src.main.java.leetCode;

public class LC19_RemoveNthNodeFromEndOfList {

//    public class ListNode {
//        public int val;
//        public practise.src.main.java.leetCode.ListNode next;
//
//        // Default constructor
//        public ListNode() {
//        }
//
//        // Constructor with value
//        public ListNode(int val) {
//            this.val = val;
//            this.next = null;
//        }
//
//        // Constructor with value and next node
//        public ListNode(int val, practise.src.main.java.leetCode.ListNode next) {
//            this.val = val;
//            this.next = next;
//        }
//    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(6);

        int k = 3;
        printLinkedList(removeNthFromEnd(head, k));


    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode res = new ListNode(0, head);
        ListNode dummy = res;

        for (int i = 0; i < n; i++) {
            head = head.next;
        }
        while (head != null) {
            head = head.next;
            dummy = dummy.next;
        }
        dummy.next = dummy.next.next;
        return res.next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }
}
