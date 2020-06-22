import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        if (n < 1) return new ArrayList<>();

        List<List<Integer[]>> solutions = new ArrayList<>();
        int[][] chessboard = new int[n][n];
        backtrack(chessboard, new ArrayList<>(), solutions);

        List<List<String>> res = new ArrayList<>();

        // turning solutions to string-format result
        for (List<Integer[]> s : solutions) {
            List<String> str = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                char[] chars = new char[n];
                Arrays.fill(chars, '.');
                chars[s.get(i)[1]] = 'Q';
                str.add(new String(chars));
            }
            res.add(str);
        }

        return res;
    }

    private void backtrack(int[][] chessboard, List<Integer[]> tmp, List<List<Integer[]>> solutions) {
        if (tmp.size() == chessboard.length) {
            solutions.add(new ArrayList(tmp));
            return;
        } 

        for (int i = 0; i < chessboard.length; i++) {
            Integer[] pos = new Integer[2];
            pos[0] = tmp.size(); // current index of row to place queen
            pos[1] = i;
            if (isValid(tmp, pos)) {
                tmp.add(pos);
                backtrack(chessboard, tmp, solutions);
                tmp.remove(tmp.size()-1);
            }
        }
    }

    // check whether prior queens conflict with this new one
    // check column, diagonal
    private boolean isValid(List<Integer[]> queens, Integer[] pos) {
        for (Integer[] q : queens) {
            if (q[1] == pos[1]) return false;
            if (Math.abs(q[0] - pos[0]) == Math.abs(q[1] - pos[1]))
                return false;
        }
        return true;
    }
}