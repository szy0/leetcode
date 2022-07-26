import java.util.*;
class Solution {
    public int numberOfSubstrings(String s) {
        LinkedList<Integer> index_a = new LinkedList<>();
        LinkedList<Integer> index_b = new LinkedList<>();
        LinkedList<Integer> index_c = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'a') 
                index_a.add(i);
            else if (s.charAt(i) == 'b') 
                index_b.add(i);
            else 
                index_c.add(i);
        }
        int sum = 0;
        for (int j = 0; j < s.length(); j++) {
            int end = 0;
            if (s.charAt(j) == 'a') {
                end = helper(j, index_b, index_c);
            }
            else if (s.charAt(j) == 'b') {
                end = helper(j, index_a, index_c);
            }
            else {
                end = helper(j, index_a, index_b);
            }
            if (end == -1) break; // no possible substrings
            sum += (s.length() - end); // all substrings after this index
        }
        return sum;
    }

    // given the index of current 'a', we need to find the larger indices of 'b' and 'c' after this index
    private int helper(int index, LinkedList<Integer> list1, LinkedList<Integer> list2) {
        while (!list1.isEmpty() && list1.peek() < index) list1.poll();
        while (!list2.isEmpty() && list2.peek() < index) list2.poll();
        if (list1.isEmpty() || list2.isEmpty()) return -1;
        return list1.peek() < list2.peek() ? list2.peek() : list1.peek();
    }
}