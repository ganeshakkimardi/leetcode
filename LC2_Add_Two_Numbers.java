package practise.leetCode;


public class LC2_Add_Two_Numbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        System.out.println("list 1");
        printList(l1);
        System.out.println("list 2");
        printList(l2);

        System.out.println("output : ");
        printList(addTwoNumbers(l1, l2));
    }

    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode temp = res;
        int total, carry = 0;

        while (l1 != null || l2 != null || carry != 0) {
            total = carry;

             if (l1 != null) {
                 total += l1.val;
                 l1 = l1.next;
             }
             if (l2 != null) {
                 total += l2.val;
                 l2 = l2.next;
             }
             int num = total % 10;
             carry = total / 10;
             temp.next = new ListNode(num);
             temp = temp.next;
        }
        return res.next;
    }


    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    
}
