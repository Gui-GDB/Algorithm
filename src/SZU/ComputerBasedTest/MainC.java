package SZU.ComputerBasedTest;/*
题目描述
    师傅教徒弟念经。大徒弟分不清p和q，碰到“q”都读“p”，碰到“p”都读“q”。二徒弟把g认成d，碰到“g”都读“d”。小徒弟喜欢偷懒，念3个漏2个。
    师傅教的经，三个徒弟会怎么念呢？
输入
    第一行输入师傅教的经
    第二行输入正在念经的徒弟（1表示大徒弟，2表示二徒弟，3表示小徒弟）
输出
    输出徒弟念的经
输入样例1：
    qinghailipipengtandanyangfunai
    1
输出样例1：
    pinghailiqiqengtandanyangfunai
输入样例2：
    qinghailipipengtandanyangfunai
    2
输出样例2：
    qindhailipipendtandanyandfunai
输入样例3：
    qinghailipipengtandanyangfunai
    3
输出样例3：
    qinailipetannyafun

 */

import java.util.Scanner;

public class MainC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int num = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (num == 1) {
                if (c == 'p')
                    c = 'q';
                else if (c == 'q')
                    c = 'p';
                sb.append(c);
            } else if (num == 2) {
                if (c == 'g')
                    c = 'd';
                sb.append(c);
            } else if (num == 3) {
                sb.append(s, i, Math.min(i + 3, s.length()));
                i += 4;
            }
        }
        System.out.println(sb);
    }
}