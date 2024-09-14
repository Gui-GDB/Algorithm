package SZU.SimulationTest;
/*
题目描述
    编写函数long change(char s[])，其作用是将参数表示的十六进制数转换为相应的十进制整数
输入
    测试数据的个数   
    第一个十六进制数
    第二个十六进制数 
    .........
输出
    第一个十进制数
    第二个十进制数
    ........
输入样例：
    3
    1234
    F8
    AB12
输出样例：
    4660
    248
    43794
 */
import java.util.Scanner;

public class MainD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(change(sc.next()));
        }
    }

    public static long change(String s) {
        long temp = 1, res = 0;
        for (int i=s.length()-1; i>=0; i--) {
            char c = s.charAt(i);
            int num;
            if (c == 'A')
                num = 10;
            else if (c == 'B')
                num = 11;
            else if (c == 'C')
                num = 12;
            else if (c == 'D')
                num = 13;
            else if (c == 'E')
                num = 14;
            else if (c == 'F')
                num = 15;
            else
                num = c - '0';
            res += num * temp;
            temp *= 16;
        }

        return res;
    }
}