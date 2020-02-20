/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ArrayList<ListNode> allNodes = new ArrayList<ListNode>();
        ArrayList<Integer> allValues = new ArrayList<Integer>();
        while (l1!=null){
            int value1 = l1.val;
            allValues.add(value1);
            l1 = l1.next;     
        }
        while (l2!=null){
            int value2 = l2.val;
            allValues.add(value2);
            l2 = l2.next;
        }
        Collections.sort(allValues);

        int length = allValues.size();
        if (length == 0){
            return null;
        } else{
            for (int i=0; i<length; i++){
                ListNode node = new ListNode(allValues.get(i));
                allNodes.add(node);
            }
            for (int i=0; i<length-1; i++){
                allNodes.get(i).next = allNodes.get(i+1);
            }
            allNodes.get(length-1).next = null;
            return allNodes.get(0);
        }
    }
}