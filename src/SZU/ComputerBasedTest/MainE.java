package SZU.ComputerBasedTest;

import java.util.Scanner;

/*
题目描述
    从键盘输入任意正整数，判断该数是否是回文数。所谓回文数就是从左到右读这个数与从右到左读这个数是一样的。例如12321、1221都是回文数。
输入
    测试案例的个数n
    第一个测试值
    第二个测试值
    .......
    第n个测试值
输出
    每个测试值输出判断结果一行，表示是否是回文数，是则输出Yes，不是则输出No
输入样例：
    3
    4554
    123
    121

输出样例：
    Yes
    No
    Yes

 */
public class MainE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            boolean flag = false;
            for (int j = 0; j < s.length() / 2; j++) {
                if (s.charAt(j) != s.charAt(s.length() - j - 1)) {
                    flag = true;
                    break;
                }
            }
            System.out.println(flag ? "No" : "Yes");
        }
    }
}