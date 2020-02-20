import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> one = new ArrayList<Integer>();
        List<List<Integer>> all = new ArrayList<List<Integer>>();

        int[] prev = removeLast(candidates); // it is ok when len <=1
        int len = candidates.length;
        if (len == 0 || target <= 0) return all;
        int last = candidates[len-1];


        if (last > target) {
            return combinationSum2(prev, target);
        } else {
            if (last == target) {
                one.add(last);
                if (!all.contains(one))
                    all.add(one);
            }
            for (List<Integer> k : combinationSum2(prev, target - last)) {
                k.add(last);
                if (!all.contains(k))
                    all.add(k);
            }
            for (List<Integer> j : combinationSum2(prev, target)) {
                if (!all.contains(j))
                    all.add(j);
            }
            return all;
        }
    }


    public int[] removeLast(int[] candidates) {

        if (candidates.length <= 1) 
            return new int[0];
        else {
            int[] result = new int[candidates.length-1];
            for (int k=0; k<candidates.length-1; k++) {
                result[k] = candidates[k];
            }   
            return result;
        }
        
    }
}