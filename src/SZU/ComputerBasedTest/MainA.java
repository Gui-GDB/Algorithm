package SZU.ComputerBasedTest;/*
题目描述
    《诗经》分为“风”、“雅”、“颂”三个部分，一共305篇。小明每天背1篇，已经背了n天。请问小明还要背几天才能把《诗经》全部背完。
输入
    输入一个正整数n（n小于305），表示小明已经背了n天
输出
    输出m，表示小明还要背m天才能把《诗经》全部背完。
输入样例：
    1
输出样例：
    304
 */

import java.util.Scanner;

public class MainA {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(305 - n);
    }
}