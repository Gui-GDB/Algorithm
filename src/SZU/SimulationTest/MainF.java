package SZU.SimulationTest;
/*
题目描述
    建议使用栈对象，编写程序实现行编辑功能。
    行编辑功能是：当输入#字符，则执行退格操作；如果无字符可退就不操作，不会报错
    本程序默认不会显示#字符，所以连续输入多个#表示连续执行多次退格操作
    每输入一行字符打回车则表示字符串结束
输入
    第一行输入一个整数t，表示有t行字符串要输入
    第二行起输入一行字符串，共输入t行
输出
    每行输出最终处理后的结果，如果一行输入的字符串经过处理后没有字符输出，则直接输出NULL
输入样例1
    4
    chinaa#
    sb#zb#u
    ##shen###zhen###
    chi##a#####

输出样例1
    china
    szu
    sz
    NULL
    
输入样例2
    1
    ###############################################################################################
    
输出样例2
    NULL
    
 */

import java.util.Scanner;
import java.util.Stack;

public class MainF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(F(sc.next()));
        }
    }

    public static String F(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != '#')
                stack.push(c);
            else {
                if (!stack.isEmpty())
                    stack.pop();
            }
        }
        if (stack.isEmpty())
            return "NULL";
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
        }
        return sb.toString();
    }
}