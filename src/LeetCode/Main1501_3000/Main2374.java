package LeetCode.Main1501_3000;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2374 {

    /**
     * 解题思路：
     * 遍历数组统计即可。
     * 时间复杂度：O(n)
     *
     * @param edges 有向图数组
     * @return 返回边积分最高的节点。
     */
    public static int edgeScore(int[] edges) {
        long[] arr = new long[edges.length];
        int result = Integer.MAX_VALUE;
        long resultValue = 0;
        for (int i = 0; i < edges.length; i++) {
            int key = edges[i];
            long value = arr[key] + i;
            arr[key] = value;
            if (value > resultValue || (value == resultValue && key < result)) {
                resultValue = value;
                result = key;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] edges = new int[n];
        for (int i = 0; i < n; i++) {
            edges[i] = sc.nextInt();
        }
        System.out.println(edgeScore(edges));
    }
}
