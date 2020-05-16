import java.util.ArrayList;

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

    // a recursive way, slow
    // public ListNode reverseList(ListNode head) {
    //     if (head == null || head.next == null)  return head;
    //     ListNode tail = head;
    //     while (tail.next != null) tail = tail.next;
    //     reverse(head);
    //     return tail;
    // }

    // private void reverse(ListNode head) {
    //     ListNode p1 = head.next;
    //     ListNode p2 = head;
    //     while (p1.next != null) {
    //         p1 = p1.next;
    //         p2 = p2.next;
    //     }
    //     p2.next = null;
    //     p1.next = p2;
    //     if (head.next != null) {
    //         reverse(head);
    //     } else return;
    // }



    //////////////////////////////
    // an iterative way
    // public ListNode reverseList(ListNode head) {
    //     if (head == null || head.next == null) return head;

    //     List<ListNode> allNodes = new ArrayList<>();
    //     while (head != null) {
    //         ListNode temp = head;
    //         head = head.next;
    //         temp.next = null;
    //         allNodes.add(temp);
    //     }

    //     for (int i = allNodes.size()-1; i >= 0; i--) {
    //         if (i >= 1) {
    //             allNodes.get(i).next = allNodes.get(i-1);
    //         }
    //     }
    //     return allNodes.get(allNodes.size()-1);
    // }
}