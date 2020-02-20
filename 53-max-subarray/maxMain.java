import java.util.*;

public class maxMain {
    public static void main(String[] args) {
        Solution s = new Solution();
        //int[] arr = {-2,1,-3,4,-1,2,1,-5,4};
        int[] arr = {-2,-2,-3,0,-3,1,-3};

        int res = s.maxSubArray(arr);
        System.out.println(res);

        // ArrayList<Integer> l1 = new ArrayList<Integer>();
        // l1.add(1);
        // l1.add(3);
        // l1.add(1);
        // //l1.remove(l1.get(l1.size()-1));
        // l1.remove(Integer.valueOf(3)); // Interger -> object int -> index 
        // printList(l1);

    }

    public static void printList(ArrayList<Integer> list) {
        for (int k = 0; k < list.size(); k++) {
            System.out.print(list.get(k) + " ");
        }
        System.out.println();
    }
}