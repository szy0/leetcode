import java.util.*;

public class Main {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1,2,3};
        List<List<Integer>> res = s.subsets(nums);
        for (List<Integer> one : res) {
            for (int k : one) System.out.print(k + " ");
            System.out.println();
        }
    }
}