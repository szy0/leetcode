/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    Solution(){}
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = lenOfLinkedList(head);
        int indexOfNodeToRemove = len - n + 1; // starting index = 1; this order is from the head
        
        if (indexOfNodeToRemove == 1) return head.next; // removing the first node, i.e. replacing the head
        
        ListNode newHead = head;
        int index = 1;
        while (index <= indexOfNodeToRemove-2) {
            head = head.next;
            index++;
        }
        head.next = head.next.next;
        
        return newHead;
    }



    public int lenOfLinkedList(ListNode head) {
        int len = 0;
        if (head.equals(null)) return len; // empty linked list
        while (head.next != null) {
            len+=1;
            head = head.next;
        }
        len +=1;
        return len;
    }
}