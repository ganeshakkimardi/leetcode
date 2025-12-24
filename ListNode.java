package practise.src.main.java.leetCode;

public class ListNode {
    public int val;
    public ListNode next;

    // Default constructor
    public ListNode() {
    }

    // Constructor with value
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    // Constructor with value and next node
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

