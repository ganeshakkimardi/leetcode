package practise.leetCode;

public class LC876_MiddleOfTheLinkedList {

    // Definition for singly-linked list.
//    static class ListNode {
//        int val;
//        ListNode next;
//
//        ListNode(int val) {
//            this.val = val;
//            this.next = null;
//        }
//    }

    static class Solution {
        public ListNode middleNode(ListNode head) {
            ListNode slow = head;
            ListNode fast = head;

            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }
    }

    // Helper method to create linked list from array
    public static ListNode createList(int[] arr) {
        if (arr.length == 0) return null;

        ListNode head = new ListNode(arr[0]);
        ListNode current = head;

        for (int i = 1; i < arr.length; i++) {
            current.next = new ListNode(arr[i]);
            current = current.next;
        }

        return head;
    }

    // Helper method to print linked list
    public static void printList(ListNode head) {
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {

        int[] input = {1, 2, 3, 4, 5};

        ListNode head = createList(input);

        System.out.print("Input List: ");
        printList(head);

        Solution sol = new Solution();
        ListNode middle = sol.middleNode(head);

        System.out.print("Middle Node onwards: ");
        printList(middle);
    }
}