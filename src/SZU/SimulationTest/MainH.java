package SZU.SimulationTest;
/*
题目描述：
    计算一颗二叉树包含的叶子结点数量。
    二叉树表示采用“含空树结点的先序遍历”的方法，例如下图的先序遍历结果为AB0C00D00，其中空树用字符‘0’表示。
输入
    第一行输入一个整数t，表示有t个测试数据
    第二行起输入二叉树先序遍历的结果，空树用字符‘0’表示，输入t行
输出
    逐行输出每个二叉树的包含的叶子数量
输入样例：
    3
    AB0C00D00
    AB00C00
    ABC00D00E00

输出样例：
    2
    2
    3
    
 */
import java.util.Scanner;

public class MainH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(H(sc.next()));
        }
    }

    public static int H(String s) {
        int result = 0;
        for (int i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == '0')
                continue;
            if (s.charAt(i + 1) == '0' && s.charAt(i + 2) == '0') {
                result++;
            }
        }
        return result;
    }
}