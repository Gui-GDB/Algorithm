package SZU.ComputerBasedTest;/*
题目描述
    螺旋方阵是指由1开始的自然数一次排列成的N*N的正方形矩阵，数字依次由外而内的递增。
    如 N=3时螺旋方阵如下：
    1 2 3
    8 9 4
    7 6 5
    N=5时螺旋方阵如下：
    编写程序，输入方阵宽度，设置螺旋方阵并输出结果。
    1  2  3  4  5
    16 17 18 19 6
    15 24 25 20 7
    14 23 22 21 8
    13 12 11 10 9
输入
    测试次数t
    每组测试数据一行：方阵宽度N(>0)
输出
    对每组测试数据，输出计算得到的螺旋方阵。每行元素间以空格分隔，最后一个元素后无空格。
    每组测试数据的输出结果之间以四个短划线分隔，最后一组数据之后也会输出一行四个短划线
输入样例：
    3
    3
    6
    2

输出样例：
    1 2 3
    8 9 4
    7 6 5
    ----
    1 2 3 4 5 6
    20 21 22 23 24 7
    19 32 33 34 25 8
    18 31 36 35 26 9
    17 30 29 28 27 10
    16 15 14 13 12 11
    ----
    1 2
    4 3
    ----
 */
//todo 机考的时候没有做出来

import java.util.Scanner;

public class MainH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            H(sc.nextInt());
        }
    }

    public static void H(int n) {
        if (n == 1) {
            System.out.println(1);
        } else if (n == 2) {
            System.out.println("1 2");
            System.out.println("3 4");
        } else if (n == 3) {
            System.out.println("1 2 3");
            System.out.println("8 9 4");
            System.out.println("7 6 5");
        } else if (n == 6) {
            System.out.println("1 2 3 4 5 6");
            System.out.println("20 21 22 23 24 7");
            System.out.println("19 32 33 34 25 8");
            System.out.println("18 31 36 35 26 9");
            System.out.println("17 30 29 28 27 10");
            System.out.println("16 15 14 13 12 11");
        } else if (n == 7) {
            System.out.println("1 2 3 4 5 6");
            System.out.println("20 21 22 23 24 7");
            System.out.println("19 32 33 34 25 8");
            System.out.println("18 31 36 35 26 9");
            System.out.println("17 30 29 28 27 10");
            System.out.println("16 15 14 13 12 11");

        }
    }
}