import java.util.*;

// It works.
// It has some redundant codes.
class Solution1 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k || n < 1 || k < 1) return res;
        if (n == 1) {
            res.add(Arrays.asList(1));
            return res;
        } 

        backtrack(1, n, k, k, res, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int start, int end, int k, int left, List<List<Integer>> res, List<Integer> temp) {
        if (temp.size() == k) {
            List<Integer> one = new ArrayList<>();
            for (int i : temp) {
                one.add(i);
            } 
            res.add(one);
        } 
        if (start <= end && k >= 1) {
            for (int i = start; i <= end; i++) {
                temp.add(i);
                backtrack(i+1, end, k, left-1, res, temp);
                temp.remove(temp.size()-1);
            }
        } 
       
        return;
    }

}