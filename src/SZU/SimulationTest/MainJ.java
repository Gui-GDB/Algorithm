package SZU.SimulationTest;
/*
题目描述
    给出一个队列和要查找的数值，找出数值在队列中的位置，队列位置从1开始
    要求使用带哨兵的顺序查找算法
    带哨兵的顺序查找算法思想是：把要查找的数值X插入到队列头部作为哨兵；
    然后从队列末尾往前查找；如果在队列中找到X则返回查找到的为止；如果碰到哨兵也停止表示查找失败
输入
    第一行输入n，表示队列有n个数据
    第二行输入n个数据，都是正整数，用空格隔开
    第三行输入t，表示有t个要查找的数值
    第四行起，输入t个数值，输入t行
输出
    每行输出一个要查找的数值在队列的位置，如果查找不成功，输出字符串error
输入样例：
    8
    33 66 22 88 11 27 44 55
    3
    22
    11
    99

输出样例：
    3
    5
    error
    
 */

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MainJ {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            q.offer(sc.nextInt());
        }
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println(J(q.toArray(), sc.nextInt()));
        }
    }

    public static String J(Object[] arr, int k) {
        int size = arr.length;
        for (int i = size - 1; i >= 0; i--) {
            if (arr[i].equals(k)) {
                return String.valueOf(i + 1);
            }
        }
        return "error";
    }
}