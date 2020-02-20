import java.util.ArrayList;

class test{
    public static void main(String[] args) {
        // Solution s = new Solution();

        // String[] allTests = {"","()","{}","[]","[]{}()","({})",
        //                     "(","}","[][","([)]","}()","{[({[]})]}"};
        // for (String i : allTests) {
        //     if (s.isValid(i)) {
        //         System.out.printf("The String %s  Result: True\n",i);
        //     } else {
        //         System.out.printf("The String %s  Result: False\n",i);
        //     }
        // }

        // the following codes are not related to this leetcode problem.
        ArrayList<Integer> justTry = new ArrayList<Integer>();
        final int len = justTry.size();
        justTry.add(10);
        System.out.println(len);
        justTry.add(20);
        System.out.println(len);
        justTry.add(30);
        System.out.println(len);
        justTry.add(40);
        System.out.println(len);
        //justTry.remove(justTry.size()-2);
        //print(justTry);
        //System.out.println(len);

    }


    public static void print(ArrayList<Integer> a) {
        for (int k : a) {
            System.out.println(k+" ");
        }
    }
}