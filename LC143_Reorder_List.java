package practise.leetCode;

public class LC143_Reorder_List {

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
        // Create linked list: 1 -> 2 -> 3 -> 4 -> null
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));

        reorderList(head);
        printList(head);
    }

    public static void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // Step 1: Find the middle of the list
        // 1 -> 2 -> 3 -> 4 -> 5 -> 6 -> 7 -> 8 -> 9
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse the second half of the list
        ListNode second = slow.next;
        // second => 6 -> 7 -> 8 -> 9
        slow.next = null;
        ListNode node = null;

        while(second != null) {
            ListNode temp = second.next;
            second.next = node;
            node = second;
            second = temp;
        }

        // Step 3. Merge 2 lists
        // 1 -> 2 -> 3 -> 4 -> 5 && 9 -> 8 -> 7 -> 6

        ListNode first = head;
        second = node;
        while (second != null) {
            ListNode temp1 = first.next, temp2 = second.next;
            first.next = second;
            second.next = temp1;
            first = temp1;
            second = temp2;
        }

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
