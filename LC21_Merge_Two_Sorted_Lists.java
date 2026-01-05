package practise.leetCode;

public class LC21_Merge_Two_Sorted_Lists {

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

    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) return list2;
        if(list2 == null) return list1;

        ListNode dummy = new ListNode();
        ListNode curr = dummy;

        while(list1 != null && list2 != null) {
            if(list1.val > list2.val) {
                curr.next = list2;
                list2 = list2.next;
            } else {
                curr.next = list1;
                list1 = list1.next;
            }
            curr = curr.next;
        }
        curr.next = (list1 != null) ? list1 : list2;
        return dummy.next;
    }

    public static void main(String[] args) {
        // List 1: 1 -> 3 -> 5
        ListNode list1 = new ListNode(1,
                new ListNode(3,
                        new ListNode(5)));

        // List 2: 2 -> 4 -> 6
        ListNode list2 = new ListNode(2,
                new ListNode(4,
                        new ListNode(6)));

        ListNode mergedHead = mergeTwoLists(list1, list2);
        printList(mergedHead);
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
