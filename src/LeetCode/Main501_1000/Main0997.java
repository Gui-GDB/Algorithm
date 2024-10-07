package LeetCode.Main501_1000;

import java.util.Scanner;

public class Main0997 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] arr = new int[m][2];
        for (int i = 0; i < m; i++) {
            arr[i][0] = sc.nextInt();
            arr[i][1] = sc.nextInt();
        }
        System.out.println(findJudge(n, arr));
    }

    /**
     * 解题思路：
     * 将小镇人数n作为图的n个结点，trust作为有向图的边。
     * 根据题意每个人都信任法官，所以其他人都会有一条指向法官的的有向边，而法官不信任任何人，所以没有从法官指向其他人的有向边。
     * 所以法官结点的入度为n-1，出度为0。
     * 时间复杂度分析：O(n+m)，m是trust的长度。
     * 空间复杂度：O(n)
     *
     * @param n     小镇的人数
     * @param trust 信任关系数组
     * @return 返回法官的编号
     */
    public static int findJudge(int n, int[][] trust) {
        int[] inDegree = new int[n + 1];
        int[] outDegree = new int[n + 1];
        for (int[] data : trust) {
            inDegree[data[1]]++;
            outDegree[data[0]]++;
        }
        for (int i = 1; i <= n; i++) {
            if (inDegree[i] == n - 1 && outDegree[i] == 0)
                return i;
        }
        return -1;
    }
}
