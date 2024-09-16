package LeetCode.Main501_1000;


import java.util.*;

public class Main0827 {
    public int largestIsland(int[][] grid) {
        int max = 0;
        int num = 2;
        int n = grid.length;
        Map<Integer, Integer> map = new HashMap<>();
        // 岛屿面积数组
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    int area = dfs(grid, i, j, num);
                    map.put(num++, area);
                    max = Math.max(max, area);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> set = new HashSet<>();
                    if (i - 1 >= 0) {
                        set.add(grid[i - 1][j]);
                    }
                    if (j - 1 >= 0) {
                        set.add(grid[i][j - 1]);
                    }
                    if (j + 1 < n) {
                        set.add(grid[i][j + 1]);
                    }
                    if (i + 1 < n) {
                        set.add(grid[i + 1][j]);
                    }
                    int temp = 1;
                    for (Integer integer : set) {
                        temp += map.getOrDefault(integer, 0);
                    }
                    max = Math.max(max, temp);
                }
            }
        }
        return max;
    }

    public int dfs(int[][] grid, int row, int col, int num) {
        int n = grid.length;
        if (row < 0 || row >= n || col < 0 || col >= n || grid[row][col] != 1)
            return 0;
        grid[row][col] = num;
        return 1 + dfs(grid, row - 1, col, num) + dfs(grid, row + 1, col, num) + dfs(grid, row, col + 1, num) + dfs(grid, row, col - 1, num);
    }

    public static void main(String[] args) {
        Main0827 main = new Main0827();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        System.out.println(main.largestIsland(grid));
    }
}
