package LeetCode.Main201_500;

import java.util.Scanner;

public class Main0463 {

    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    return dfs(grid, i, j) ;
                }
            }
        }
        return 0;
    }

    public int dfs(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
            return 0;
        }
        grid[row][col] = 2;
        int count = 4;
        if (row > 0 && grid[row - 1][col] != 0) {
            count--;
        }
        if (col > 0 && grid[row][col - 1] != 0) {
            count--;
        }
        if (row < grid.length - 1 && grid[row + 1][col] != 0) {
            count--;
        }
        if (col < grid[0].length - 1 && grid[row][col + 1] != 0) {
            count--;
        }
        return count + dfs(grid, row + 1, col) + dfs(grid, row - 1, col) + dfs(grid, row, col + 1) + dfs(grid, row, col - 1);
    }

    public static void main(String[] args) {
        Main0463 main = new Main0463();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(main.islandPerimeter(grid));
    }
}
