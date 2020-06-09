/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    // O(n log n) means divide and conquer (merge sort)
    // merge sort is suitable for linked list 
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode prev = head, slow = head, fast = head;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        prev.next = null; // cutting the list to two halves
        head = sortList(head);
        slow = sortList(slow);

        return merge(head, slow);
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        ListNode res = new ListNode();
        ListNode head = res;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                res.next = head1;
                head1 = head1.next;
                res = res.next;
            } else {
                res.next = head2;
                head2 = head2.next;
                res = res.next;
            }
        }

        if (head1 != null) res.next = head1;
        if (head2 != null) res.next = head2;

        return head.next;
    }
}

