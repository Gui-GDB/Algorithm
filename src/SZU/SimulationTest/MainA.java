package SZU.SimulationTest;
/*
题目描述
    给你一些数，编号从1开始，你的任务是求出其中一段区间的数的总和。
输入
    第一行输入一个整数n（n<=100）。
    第二行输入n个整数。
    第三行输入两个整数L和R，表示所求区间的左标和右标。
输出
    输出从L到R区间的数的总和。
输入样例
    6
    -1 3 4 -2 5 -6
    2 4
输出样例
    5
 */

import java.util.Scanner;

public class MainA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int l = sc.nextInt() - 1;
        int r = sc.nextInt();
        int sum = 0;
        for (; l < r; l++) {
            sum += arr[l];
        }
        System.out.println(sum);
    }
}