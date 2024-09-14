package SZU.ComputerBasedTest;

import java.util.Scanner;

/*
题目描述
    给定一个字符串，求需要添加至少几个字符才能使得整个字符串由某一个不为本身的子串循环构成？
    如"abca"，添加"bc"后构成"abcabc"，其由子串"abc"循环构成;也可以添加"abca"后构成"abcaabca"，其由子串"abca"循环构成，相比之下"bc"只有2个字符，添加的字符量最少。
输入
    第一行包括一个整数T(1 <= T <= 100)，代表测试组数
    每组测试数据包括一行字符串，其长度范围为 [3, 104]
输出
    对于每组测试数据
    输出一个整数N，代表添加的最小字符数量
输入样例：
    3
    aaa
    abca
    abcdefg

输出样例：
    0
    2
    7

 */
public class MainF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println(F(sc.next()));
        }
    }

    public static int F(String s) {
        for (int i = 1; i < s.length(); i++) {
            String temp = s.substring(0, i);
            for (int j = 0; j < s.length(); j += i) {
                String temp2 = "";
                if (j + i > s.length()) {
                    temp2 = s.substring(j);
                    if (temp2.equals(temp.substring(0, s.length() - j))) {
                        return i - s.length() + j;
                    }
                } else {
                    temp2 = s.substring(j, j + i);
                    if (!temp.equals(temp2))
                        break;
                    if (j + i == s.length())
                        return 0;
                }
            }
        }
        return s.length();
    }
}