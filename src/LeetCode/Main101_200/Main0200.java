package LeetCode.Main101_200;

import java.util.Scanner;

public class Main0200 {
    /**
     * 题目思路：
     * 遍历二维网格，将相邻位置是1的位置全部都记录下来，然后依次枚举每个位置检查是否被遍历过，
     * 如果遍历过或者是0就跳过，否则就重复上面的遍历，直到找不到相邻的位置为1位置。将所有位置遍历结束就可以得到岛屿的数量。
     * 复杂度分析：
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param grid 二维网格
     * @return 返回岛屿数量
     */
    public int numIslands(char[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    visitedLand(grid, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    public void visitedLand(char[][] grid, int x, int y) {
        //防止网格越界，也就是防止超出岛屿（上下左右）的范围。特别注意当遍历到海洋的时候也退出循环,注意：标记过的地方不能再遍历了
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != '1')
            return;
        grid[x][y] = '2';  // 标记这块路径已经查找过了
        // 向上遍历是否有相邻的陆地
        visitedLand(grid, x - 1, y);
        // 向下遍历
        visitedLand(grid, x + 1, y);
        // 向左遍历
        visitedLand(grid, x, y - 1);
        // 向右遍历
        visitedLand(grid, x, y + 1);
    }

    public static void main(String[] args) {
        Main0200 main = new Main0200();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                grid[i][j] = sc.next().charAt(0);
            }
        }
        System.out.println(main.numIslands(grid));
    }
}
