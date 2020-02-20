import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;


public class perMain {
    public static void main(String[] args) {
        Solution s = new Solution();

        // int[] nums = {1,1,2,2,3,3};//cannot pass
        int[] nums = {1,1,2,2};
        List<List<Integer>> result = s.permuteUnique(nums);

        int count = 1;
        for (List<Integer> k : result) {
            System.out.printf("List %d: ", count++);
            for (int m : k) {
                System.out.print(m + " ");
            }
            System.out.print("\n");
        }

        // List<List<Integer>> all = new ArrayList<List<Integer>>();
        // all = Arrays.asList(Arrays.asList(10,20,30));

        // List<List<Integer>> part = new ArrayList<List<Integer>>();
        // part = Arrays.asList(Arrays.asList(11,22,33));

        // List<Integer> all = new ArrayList<Integer>();
        // all.add(-1);
        // all.add(-2);
        // all.add(-3);

        // List<Integer> part = new ArrayList<Integer>();
        // part.add(11);
        // part.add(22);
        // part.add(33);


        // all.addAll(part);

        // for (int k : all) {
        //     System.out.println(k + " ");
        // }


    }
}


        // List<Integer> m = new ArrayList<Integer>();
        // m.add(10);
        // m.add(20);
        // m.add(30);
        // m.add(3,-1);
        // for (int k=0; k<m.size(); k++) {
        //     System.out.println(m.get(k));
        // }
