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
    // two pointers
    // O(n) time, O(n) space
    public boolean isPalindrome(ListNode head) {
        if (head == null) return true;
        ListNode p1 = head; // fast pointer
        ListNode p2 = head; // slow pointer

        int num = 1; // num of nodes
        while(p1.next != null) {
            p1 = p1.next;
            num++;
        }

        int[] values = new int[num];
        p1 = head;
        for (int i = 0; i < num; i++) {
            values[i] = p1.val;
            p1 = p1.next;
        }

        for (int j = num-1; j >= 0; j--) {
            if (values[j] != p2.val) return false;
            else {
                p2 = p2.next;
            }
        }
        return true;

    }

}