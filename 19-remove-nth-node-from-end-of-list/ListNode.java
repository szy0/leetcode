/**
 * Definition for singly-linked list.
 */

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode node2 = new ListNode(20);
        ListNode node3 = new ListNode(30);
        ListNode node4 = new ListNode(40);
        ListNode last = new ListNode(-10);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = last;

        Solution s = new Solution();
        int len = s.lenOfLinkedList(head);
        System.out.println(len);
        System.out.println(head.next.next.val); // this test show that java passes by reference
        // value is 30, means calling external method will not influence this linked list
    }
}
