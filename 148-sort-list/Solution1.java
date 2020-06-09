class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode min = head;
        ListNode tmp = head;

        while (tmp != null) {
            if (tmp.val < min.val) {
                min = tmp;
            }
            tmp = tmp.next;
        }
        tmp = min.next;

        if (min != head) {
            min.next = head;

            ListNode p = head;
            while (p.next != min) {
                p = p.next;
            }
            p.next = tmp;
            min.next = sortList(head);
            return min;
        } else {
            min.next = sortList(tmp);
            return min;
        }


    }
}