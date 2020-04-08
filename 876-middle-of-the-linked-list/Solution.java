/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */


// two pointers (fast and slow ones)
class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode p1 = head; // slower by one step a time
        ListNode p2 = head; // faster by two steps a time
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        return p1;
    }
}


// standard approach
// class Solution {
//     public ListNode middleNode(ListNode head) {
//         if (head == null || head.next == null) return head;

//         ListNode temp = head;
//         int amount = 1;
//         while (temp.next != null) {
//             temp = temp.next;
//             amount++;
//         }

//         ListNode mid = head;
//         int index = 1;
//         while (index < amount/2 + 1) {
//             index++;
//             mid = mid.next;
//         }
//         return mid;
//     }
// }