/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution1 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //l1 = l1.next;
        //System.out.println(l1.val);
        long num1 = 0;
        long num2 = 0;
        long sum = 0;

        int digit1 = 0;
        while (l1 != null){
            long value = l1.val*(long)Math.pow(10,digit1);
            num1 += value;
            digit1 ++;
            l1 = l1.next;
            //System.out.printf("current value=%f\n",value);
        }
        int digit2 = 0;
        while (l2 != null){
            long value = l2.val*(long)Math.pow(10,digit2);
            num2 += value;
            digit2 ++;
            l2=l2.next;
        }

        //System.out.printf("digit1=%d, digit2=%d\n",digit1,digit2);
        sum = num1 + num2;
        //System.out.printf("num1=%f, num2=%f,sum = %f\n",num1,num2,sum);

        int digit3 = 1;
        while ((sum-sum%Math.pow(10,digit3))!=0){
            digit3 +=1;
        }
        System.out.printf("last digit3= %d\n",digit3);

        if (digit3 == 1){
            int result = (int)sum;
            ListNode head = new ListNode(result);
            return head;
        } else {
        int[] values = new int[digit3];

        int count3 = 1;
        long newsum = sum;
        while (count3 <= digit3){
            int val = (int)(newsum%10);
            //System.out.printf("newsum is %d, val is %d",newsum,val);
            values[count3-1] = val;
            newsum = (newsum-val)/10;
            count3++;
        } 

        ListNode head = new ListNode(values[0]);
        ListNode[] otherNodes = new ListNode[digit3-1]; //all other nodes after the head
        for(int count4=1;count4<digit3;count4++){
            ListNode node = new ListNode(values[count4]);
            //System.out.println(node.val);

            otherNodes[count4-1] = node;
        }
        //System.out.println(head.val);
        head.next = otherNodes[0];
        for(int count5 = 0; count5<digit3-2; count5++){
            otherNodes[count5].next = otherNodes[count5+1];
        }
        otherNodes[digit3-2].next = null;

        return head;
    }



    }
}