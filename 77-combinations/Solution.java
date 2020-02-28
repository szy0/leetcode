import java.util.*;

// It works.
// It has some redundant codes.
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(1, n, k, res, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int start, int end, int k, List<List<Integer>> res, List<Integer> temp) {
        if (k == 0) {
            res.add(new ArrayList<>(temp));
            return;
        } 
        for (int i = start; i <= end; i++) {
            temp.add(i);
            backtrack(i+1, end, k-1, res, temp);
            temp.remove(temp.size()-1);
        }
       
    }

}