class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n]; // saving time, avoiding to loop the same island
        int area = 0; // max area

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    area = Math.max(area, findIslandArea(grid, visited, i, j));
                }
            }
        }
        return area;
    }

    private int findIslandArea(int[][] grid, boolean[][] visited, int i, int j) {
        int area = 0;
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) return 0;
        if (grid[i][j] == 0 || visited[i][j]) return 0;
       
        area++;
        visited[i][j] = true;
    
        area += findIslandArea(grid, visited, i + 1, j);
        area += findIslandArea(grid, visited, i - 1, j);
        area += findIslandArea(grid, visited, i, j + 1);
        area += findIslandArea(grid, visited, i, j - 1);
        return area;
    }
}