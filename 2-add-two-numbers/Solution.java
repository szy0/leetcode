/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
import java.util.ArrayList;

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //l1 = l1.next;
        //System.out.println(l1.val);

        ArrayList<Integer> values = new ArrayList<Integer>();
        int carry = 0;
        
        while(l2!=null && l1!=null){
            int sum = l1.val + l2.val + carry;
            int value = sum%10;
            values.add(value);
            carry = (sum==value)?0:1;

            l1=l1.next;
            l2=l2.next;
        }
        if (l2==null){
            while (l1!=null){
                int sum = l1.val + carry;
                int value = sum%10;
                values.add(value);
                carry = (sum==value)?0:1;
                l1=l1.next;
            }
            if (carry ==1){
                values.add(carry);
            }
        } else if (l1==null){
            while (l2!=null){
                int sum = l2.val + carry;
                int value = sum%10;
                values.add(value);
                carry = (sum==value)?0:1;
                l2=l2.next;
            }
            if (carry ==1){
                values.add(carry);
            }
        }
        
        int digit3 = values.size();
        //System.out.printf("digit3 = %d\n",digit3);

        ListNode[] allNodes = new ListNode[digit3];
        for(int i=0; i<digit3; i++){
            ListNode node = new ListNode(values.get(i));
            allNodes[i] = node;
        }

        for(int i=0; i<digit3-1; i++){
            allNodes[i].next = allNodes[i+1];
        }
        allNodes[digit3-1].next = null;

        ListNode head = allNodes[0];
        return head;
    }
}