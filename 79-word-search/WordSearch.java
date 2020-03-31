public class WordSearch {
    public static void main(String[] args) {
        String word = "";
        String[][] boardTemp = {{"A","B","C","E"},{"S","F","C","S"},{"A","D","E","E"}};
    
        int len1 = boardTemp.length;
        int len2 = boardTemp[0].length;

        char[][] board = new char[len1][len2];

        for (int i = 0; i < len1; i++) {
            for (int k = 0; k < len2; k++) {
                board[i][k] = boardTemp[i][k].charAt(0);
                System.out.print(boardTemp[i][k] + " ");
            }
            System.out.println();
        }

        Solution s = new Solution();
        System.out.println("word: " + word);
        System.out.println(s.exist(board, word));

    }
}