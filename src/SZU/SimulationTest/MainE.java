package SZU.SimulationTest;
/*
题目描述
    输入一个N*M的矩阵，要求将这个矩阵向左旋转90度后输出
    比如现在有矩阵 ：
        1 2 3
        4 5 6
    向左旋转90度后的矩阵变为：
        3 6
        2 5
        1 4
输入
    第一行输入T表示有T个测试实例
    第二行输入矩阵维度N和M，表示N行和M列
    第三行起输入矩阵数据，矩阵数据用自然数表示
    下面依次类推
输出
    输出左转90度的矩阵
    注意每行最后一个数据不带空格，直接换行
输入样例
    2
    2 3
    1 2 3
    4 5 6
    3 3
    1 2 3
    4 5 6
    7 8 9

输出样例
    3 6
    2 5
    1 4
    3 6 9
    2 5 8
    1 4 7

 */

import java.util.Scanner;

public class MainE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int[][] arr = new int[N][M];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    arr[j][k] = sc.nextInt();
                }
            }
            for (int j = M - 1; j >= 0; j--) {
                for (int k = 0; k < N; k++) {
                    if (k == N - 1) {
                        System.out.println(arr[k][j]);
                    } else
                        System.out.print(arr[k][j] + " ");
                }
            }
        }
    }
}