import java.util.HashSet;

class test {
    public static void main(String[] args) {
        HashSet<int[]> test = new HashSet<>();
        int[] a = {1,2};
        test.add(new int[]{1,2});
        test.add(new int[]{2,3});
        System.out.println(test.contains(a));
    }
}