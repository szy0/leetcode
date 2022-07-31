import java.util.List;
public class sumMain {
    public static void main(String[] args) {
        Solution s = new Solution();
        int[] candidate = {2,3,5};
        int target = 8;
        System.out.println(target);
        
        List<List<Integer>> a = s.combinationSum(candidate, target);

        for (List<Integer> k : a) {
            for (Integer l : k) {
                System.out.printf("%d ", l);
            }
            System.out.println("\n");
        }
    }
}