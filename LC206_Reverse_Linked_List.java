package practise.leetCode;


public class LC206_Reverse_Linked_List {

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

    public static ListNode reverseList(ListNode head) {
        ListNode node = null;
        while(head != null) {
            ListNode temp = head.next;
            head.next = node;
            node = head;
            head = temp;
        }
        return node;
    }

    public static void main(String[] args) {
        // Create linked list: 1 -> 2 -> 3 -> 4 -> null
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));

        ListNode reversedHead = reverseList(head);
        printList(reversedHead);
    }

    private static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

}
