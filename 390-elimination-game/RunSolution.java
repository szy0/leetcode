public class RunSolution {
    public static void main(String[] args) throws Exception {
        for (int n = 1; n <= 10; n++) {
            printArr(n);
            Solution sol = new Solution();
            System.out.println("last remain: " + sol.lastRemaining(n));
        }
        
    }
    private static void printArr(int n) {
        System.out.print("[1");
        for (int i = 2; i <= n; i++) {
            System.out.print(" " + i);
        }
        System.out.print("] \n");
    }
}
