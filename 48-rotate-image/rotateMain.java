import java.util.*;

public class rotateMain {
    public static void main(String[] args) {
        ArrayList<int[][]> allMatrix = new ArrayList<>();
        Solution s = new Solution();
        int[][] m2 = createMatrix(2);
        int[][] m3 = createMatrix(3);
        int[][] m4 = createMatrix(4);
        int[][] m5 = createMatrix(5);
        int[][] m6 = createMatrix(6);
        int[][] m7 = createMatrix(7);

        allMatrix.add(m2);
        allMatrix.add(m3);
        allMatrix.add(m4);
        allMatrix.add(m5);
        allMatrix.add(m6);
        allMatrix.add(m7);


        for (int[][] m : allMatrix) {
            printMatrix(m);
            System.out.println();
            s.rotate(m);
            System.out.println("After rotating ->");
            printMatrix(m);
            System.out.println("\n");
        }


    }

    private static void printMatrix(int[][] m) {
        int N = m.length;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.printf("%4s",m[i][j]);
            }
            System.out.println();
        }
    }

    private static int[][] createMatrix(int N) {
        int count = 1;
        int[][] res = new int[N][N];

        for (int row = 0; row < N; row++) {
            for (int column = 0; column < N; column++) {
                res[row][column] = count;
                count++;
            }
        }
        return res;
    }
}