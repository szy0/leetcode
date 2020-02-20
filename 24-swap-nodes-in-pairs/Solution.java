/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// recursion??

class Solution {
    public static ListNode swapPairs(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode newHead = new ListNode(head.next.val); // i highly doubt that problem is here
        newHead.next = head;// swapping the first two nodes

        if (head.next.next == null) { // this is not acceptable why?
            head.next = null;
        } else {
            head.next = swapPairs(head.next.next);
        }

        return newHead;

    }
    public static void main(String[] args) {
        ListNode l1 = new ListNode(10);
        ListNode l2 = new ListNode(20);
        l1.next = l2;

        System.out.println(l2.next);
        ListNode k = swapPairs(l1);
        System.out.println(k.val);

    }
}

    
