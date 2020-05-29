class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int num = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    if (!visited[i][j]) {
                        findConnection(grid, i, j, visited);
                        num +=1;
                    }
                }
            }
        }
        return num;
    }

    private void findConnection(char[][] grid, int i, int j, boolean[][] visited) {
       
        if (!visited[i][j]) {
            visited[i][j] = true;
                 // left
            if (j - 1 >= 0 && grid[i][j-1] == '1') findConnection(grid, i, j-1, visited);
            // right
            if (j + 1 <= grid[0].length-1 && grid[i][j + 1] == '1') findConnection(grid, i, j+1, visited);
            // up
            if (i - 1 >= 0 && grid[i-1][j] == '1') findConnection(grid, i-1, j, visited);
            // down
            if (i + 1 <= grid.length-1 && grid[i+1][j] == '1') findConnection(grid, i+1, j, visited);
        } else {
            return;
        }
    }

}