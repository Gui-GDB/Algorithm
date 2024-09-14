package SZU.SimulationTest;
/*
题目描述
    输入一个正整数，输出它的所有质数的因子（如180的质数因子为2、2、3、3、5）
输入样例
    180
输出样例
    2 2 2 3 3 5
 */

import java.util.ArrayList;
import java.util.Scanner;

public class MainB {
    public static int max_num = 10000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean[] arr = new boolean[max_num];
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 2; i < max_num; i++) {
            if (!arr[i]) {
                for (int j = i + i; j < max_num; j *= 2) {
                    arr[j] = true;
                }
            }
        }
        for (int i = 2; i < max_num; i++) {
            if (!arr[i]) {
                list.add(i);
            }
        }
        int n = sc.nextInt();
        for (Integer integer : list) {
            while (n % integer == 0) {
                System.out.print(integer + " ");
                n /= integer;
            }
        }
        if (n != 1) {
            System.out.print(n);
        }
    }
}