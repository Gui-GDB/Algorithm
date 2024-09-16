package LeetCode.Main501_1000;

public class Main0695 {
    public int maxAreaOfIsland(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    max = Math.max(visitedLand(grid, i, j, 0), max);
                }
            }
        }
        return max;
    }

    public int visitedLand(int[][] grid, int x, int y, int res) {
        if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] != 1)
            return res;
        grid[x][y] = 2;
        return 1 + visitedLand(grid, x + 1, y, res) + visitedLand(grid, x - 1, y, res) + visitedLand(grid, x, y + 1, res) + visitedLand(grid, x, y - 1, res);
    }
}
