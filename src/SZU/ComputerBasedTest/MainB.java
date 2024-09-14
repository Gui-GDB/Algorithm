package SZU.ComputerBasedTest;

import java.util.Scanner;

/*
题目描述
    《西游记》中孙悟空所使用的兵器是如意金箍棒，能跟随孙悟空心意随意变化大小。如意金箍棒现在长m米。孙悟空喊一声”bigger“，如意金箍棒的长度变为n倍；孙悟空喊一声”smaller“，如意金箍棒的长度变为1/n。
    请帮如意金箍棒算一算，孙悟空喊完，它到底应该变多长？
输入
    第一行输入一个正数m，表示如意金箍棒现在的长度；
    第二行输入一个正数n，表示变化的倍数。
    接着输入孙悟空的喊声，bigger或者smaller
输出
    输出孙悟空喊完后，如意金箍棒的长度。数值精确到小数点后1位
输入样例1：
    1
    2
    bigger
输出样例1:
    2.0
输入样例2：
    1
    2
    smaller
输出样例2：
    0.5
 */
public class MainB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double m = sc.nextDouble();
        int n = sc.nextInt();
        String word = sc.next();
        if ("bigger".equals(word)) {
            System.out.printf("%.1f", m * n);
        } else if ("smaller".equals(word)) {
            System.out.printf("%.1f", m / n);
        }
    }
}