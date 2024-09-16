package LeetCode.Main1101_1500;

import java.util.Scanner;

public class Main1184 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] distance = new int[n];
        for (int i = 0; i < n; i++) {
            distance[i] = sc.nextInt();
        }
        int start = sc.nextInt(), destination = sc.nextInt();
        System.out.println(distanceBetweenBusStops(distance, start, destination));
    }

    /**
     * 解题思路：
     * 公交车要么顺时针走要么逆时针走，逆时针路程 = 总路程 - 顺时针路程
     * 复杂度分析：
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     *
     * @param distance    每个相邻公交车站之间的距离
     * @param start       起始公交车站
     * @param destination 终止公交车站
     * @return 返回最短的路程
     */
    public static int distanceBetweenBusStops(int[] distance, int start, int destination) {
        // 求出环形一圈的总路程
        int all_distance = 0;
        for (int distance1 : distance) {
            all_distance += distance1;
        }
        //求出顺时针的路程长度
        int res = 0;
        while (start != destination && start < distance.length) {
            res += distance[start++];
        }
        if (start == distance.length) {
            start = 0;
            while (start < destination) {
                res += distance[start++];
            }
        }
        return Math.min(res, (all_distance - res));
    }
}
