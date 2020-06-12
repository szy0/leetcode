public class Main {
    public static void main(String[] args) {
        String test1 = "abc3[cd]xyz";
        // Solution s = new Solution();
        // String res  = s.decodeString(test1);
        // System.out.println(test1 + "\n" + res + "\n");

        Solution1 s1 = new Solution1();
        String res1  = s1.decodeString(test1);
        System.out.println(test1 + "\n" + res1 + "\n");

    }
}