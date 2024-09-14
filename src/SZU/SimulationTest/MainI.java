package SZU.SimulationTest;
/*
题目描述：
    给出一个图的邻接矩阵，对图进行深度优先搜索，从顶点0开始。
    注意：图n个顶点编号从0到n-1
输入：
    第一行输入t，表示有t个测试实例
    第二行输入n，表示第1个图有n个结点
    第三行起，每行输入邻接矩阵的一行，以此类推输入n行
    第i个结点与其他结点相连则为1，无连接则为0，数据之间用空格隔开。
    以此类推输入下一个示例
输出：
    每行输出一个图的深度优先搜索结果，结点编号之间用空格隔开
输入样例：
    0 1 0 0
    1 0 1 1
    0 1 0 0
    0 1 0 0
输出样例：
    0 1 2 3
 */

//todo 这个题目模拟的时候没有做出来，后面用gpt做了一下，不知道有没有通过所有的测试点

import java.util.Scanner;

public class MainI {

    // 邻接矩阵，假设图是无向的
    private final int[][] adjMatrix;
    private final int numVertices;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[][] arr = new int[n][n];
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            MainI main = new MainI(arr);
            main.dfsTraversal();
        }
    }

    public MainI(int[][] adjMatrix) {
        this.adjMatrix = adjMatrix;
        this.numVertices = adjMatrix.length;
    }

    // 深度优先搜索方法
    public void dfs(int startVertex, boolean[] visited) {
        // 标记当前节点为已访问
        visited[startVertex] = true;
        System.out.print(startVertex + " "); // 或者将节点序号添加到列表中

        // 遍历当前节点的所有邻居
        for (int i = 0; i < numVertices; i++) {
            if (adjMatrix[startVertex][i] == 1 && !visited[i]) {
                // 如果邻居节点未被访问，则递归访问它
                dfs(i, visited);
            }
        }
    }

    // 遍历图的所有连通分量
    public void dfsTraversal() {
        boolean[] visited = new boolean[numVertices];

        // 初始化visited数组为false
        for (int i = 0; i < numVertices; i++) {
            visited[i] = false;
        }

        // 遍历每个顶点，如果未被访问，则从该顶点开始进行DFS
        for (int i = 0; i < numVertices; i++) {
            if (!visited[i]) {
                dfs(i, visited);
                // 在每个连通分量遍历完成后，可以添加一些分隔符或换行符（如果需要）
                System.out.println(); // 例如，在每个连通分量后打印换行
            }
        }
    }
}