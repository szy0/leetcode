/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 // note that in this problem, cycle only connects from TAIL to front nodes
 // the key idea is to check whether a node would be visited (>=) twice
 // so actually I can use HashSet<ListNode>, my own solution will change the listnode, 
 // which is not a good.
public class Solution {
    
    public boolean hasCycle(ListNode head) {
        while (true) {
            if (head == null || head.next == null) return false;
            //System.out.println("current node val " + head.val);
            if (selfCycle(head)) return true;

            // pass by reference
            ListNode temp = head;
            head = head.next;
            temp.next = temp;
        }
    }

    private boolean selfCycle(ListNode node) {
        // compare whether they are the same node (in RAM) i.e. self-cycled
        // System.out.println("node address " + node);
        if (node.next == node) return true;
        else return false;
    }
}


// // from other coders
// // walker moves to next by one step a time
// // runner moves to next to next, two steps a time
// // if there is a cycle, after multiple iterations, two pointers will meet somewhere

// public class Solution {
//     public boolean hasCycle(ListNode head) {
//         ListNode walker = head;
//         ListNode runner = head;
//         while(runner!=null && runner.next!=null) {
//             walker = walker.next;
//             runner = runner.next.next;
//             if(walker==runner) return true;
//         }
//         return false;
//     }
// }