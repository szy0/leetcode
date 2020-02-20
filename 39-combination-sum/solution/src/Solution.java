import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> one = new ArrayList<Integer>();
        List<List<Integer>> all = new ArrayList<List<Integer>>();

        Arrays.sort(candidates);
        if (candidates.length == 0) return all;
        int[] preCan = removeLast(candidates); // previous candidates
        int last = candidates[candidates.length-1];

        int limit = target/last;
        if (limit * last == target) {
            int k = 1;
            while (k<=limit) {
                one.add(last);
                k++;
            }
            all.add(one);
        }
        if (limit == 0) {
            return combinationSum(preCan, target);
        }

        int times = 0;
        while ( preCan.length > 0 && target - last*times >= preCan[0]) {
            List<List<Integer>> previous = combinationSum(preCan, target - last*times);
            for (List<Integer> p : previous) {
                int m = 1;
                while (m<=times) {
                    p.add(last);
                    m++;
                }
                all.add(p);
            }
            times++;
        }
        return all;
    }
        
 

    public int[] removeLast(int[] candidates) {
        int[] result = new int[candidates.length-1];
        int k = 0;
        while (k < candidates.length-1){
            result[k] = candidates[k];
            k++;
        }
        return result;
    }
}