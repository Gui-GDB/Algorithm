package SZU.ComputerBasedTest;

import java.util.Scanner;

/*
题目描述
    输入三角形的三条边，输出三角形的面积。
    使用海伦公式：
    S = (a+b+c)/2
    area = √(S*(S-a)*(S-b)*(S-c))    ，√表示开平方运算
    提示：C或C++中，可以使用math库中的sqrt(double x)函数开平方
输入
    第一行输入一个正整数T，表示有T组测试样例。
    接下来的每一行包含三个正整数a, b, c，表示三角形的边长。
输出
    每一行输出一个浮点数，表示面积，要求保留两位小数。
输入样例：
    2
    3 4 5
    6 6 6

输出样例：
    6.00
    15.59

 */
public class MainD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for (int i = 0; i < T; i++) {
            int a = sc.nextInt(), b = sc.nextInt(), c = sc.nextInt();
            double S = (a + b + c) / 2.0;
            double area = Math.sqrt(S * (S - a) * (S - b) * (S - c));
            System.out.printf("%.2f\n", area);
        }
    }
}