import java.util.*;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int level = 0;
        List<Integer> res = new ArrayList<>();
        int lenv = matrix.length; // length vertical & length horizontal
        if (lenv == 0) return res;
        int lenh = matrix[0].length;
        if (lenh == 0) return res;


        while (level < (lenv + 1)/2 && level < (lenh + 1)/2) {
            List<Integer> res1 = upPrint(matrix, level);
            List<Integer> res2 = rightPrint(matrix, level);
            List<Integer> res3 = downPrint(matrix, level);
            List<Integer> res4 = leftPrint(matrix, level);
            
            res.addAll(res1);
            res.addAll(res2);

            if (lenv - 1 != level * 2)
                res.addAll(res3);
            else
                break;
            
            if (lenh - 1 != level * 2)
                res.addAll(res4);
            else
                break;
     

            level++;
        }
        return res;
        
    }


    private List<Integer> upPrint(int[][] matrix, int level) {
        List<Integer> res = new ArrayList<>();
        int lenh = matrix[0].length;
        for (int i = level; i < lenh - level; i++) {
            res.add(matrix[level][i]);
        }
        return res;
    }

    private List<Integer> rightPrint(int[][] matrix, int level) {
        List<Integer> res = new ArrayList<>();
        int lenv = matrix.length;
        int lenh = matrix[0].length;
        for (int i = level + 1; i < lenv - level - 1; i++) {
            res.add(matrix[i][lenh - 1 - level]);
        }
        return res;
    }

    private List<Integer> downPrint(int[][] matrix, int level) {
        List<Integer> res = new ArrayList<>();
        int lenh = matrix[0].length;
        int lenv = matrix.length;
        for (int i = level; i < lenh - level; i++) {
            res.add(matrix[lenv -1 -level][lenh - 1 - i]);
        }
        return res;
    }

    private List<Integer> leftPrint(int[][] matrix, int level) {
        List<Integer> res = new ArrayList<>();
        int lenv = matrix.length;
        int lenh = matrix[0].length;
        for (int i = level + 1; i < lenv - level - 1; i++) {
            res.add(matrix[lenv -1 - i][level]);
        }
        return res;
    }

    
}