import java.util.*;
// this solution works well, just being slow, exceeding time limit
// I wrote this backtracking solution by myself
class Solution {
    public boolean exist(char[][] board, String word) {
        if (board.length == 0 || board[0].length == 0) return false;
        if (word == null || word.length() <= 0) return false;


        int len = word.length();
        char[] chars = new char[len];
        for (int i = 0; i < len; i++) {
            chars[i] = word.charAt(i);
        }

        boolean[][] state = new boolean[board.length][board[0].length]; // false by default

        List<List<int[]>> res = new ArrayList<>();
        for (int i = 0; i < board.length; i++) {
            for (int k = 0; k < board[0].length; k++) {
                if (board[i][k] == chars[0]) {
                    //System.out.println("head pos:" + i +" " + k);
                    int[] headPos = new int[]{i, k};
                    List<int[]> head = new ArrayList<>();
                    head.add(headPos);

                    state[i][k] = true;
                    backtrack(board, chars, state, headPos, 1, head, res);

                    if (res.size() >= 1) return true;
                    state = new boolean[board.length][board[0].length];
                }
            }
        }

        return false;

    }

    public void backtrack(char[][] board, char[] chars, boolean[][] state, int[] lastPos, int nextCharIndex,
        List<int[]> temp, List<List<int[]>> res) {

            if (temp.size() == chars.length) {
                res.add(new ArrayList<int[]>(temp));
                return;
            }

            char nextChar = chars[nextCharIndex];
            int[] up = new int[]{lastPos[0]-1, lastPos[1]};
            int[] down = new int[]{lastPos[0]+1, lastPos[1]};
            int[] left = new int[]{lastPos[0], lastPos[1] - 1};
            int[] right = new int[]{lastPos[0], lastPos[1] + 1};

            int[][] fourPos = new int[][]{up, down, left, right};

            for (int[] pos : fourPos) {
                if (isValidPos(board, pos)) {
                    //System.out.println("4 pos " + pos[0] + " " + pos[1]);

                    if (!hasPassed(state, pos)) { // contains may not work for int[]
                        if (board[pos[0]][pos[1]] == nextChar) {
                            temp.add(pos);
                            state[pos[0]][pos[1]] = true;
                            //printChain(board, temp);
        
                            backtrack(board, chars, state, pos, nextCharIndex + 1, temp, res);
                        
                            temp.remove(pos);
                            state[pos[0]][pos[1]] = false;
                        }
                    }
                }
            }

    }

    public boolean isValidPos(char[][] board, int[] pos) {
        int len1 = board.length;
        int len2 = board[0].length;

        if (pos[0] < 0 || pos[0] >= len1) return false;
        if (pos[1] < 0 || pos[1] >= len2) return false;
        return true;
    }

    public boolean hasPassed(boolean[][] state, int[] pos) {
        return state[pos[0]][pos[1]];
    }

    public void printChain(char[][] board, List<int[]> chain) {
        for (int[] k : chain) {
            System.out.print(board[k[0]][k[1]] + " -> ");
        }
        System.out.println();
    }
}