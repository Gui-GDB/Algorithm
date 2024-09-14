package SZU.SimulationTest;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
题目描述
    对候选人得票的统计程序。设有3个候选人，每个选民投票输入一个得票的候选人的名字，要求最后输出各人得票结果。
    三个候选人的名字分别为Li， Zhang， Fu。
输入
    第一行输入输入选票数n
    第二行起输入n行，每行是一个候选人名字
输出
    三个候选人的统计结果
输入样例
    5
    Li
    Fu
    Fu
    Zhao
    Bai
输出样例
    Li:1
    Zhang:0
    Fu:2
 */
public class MainC {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        System.out.println("Li:" + map.getOrDefault("Li", 0));
        System.out.println("Zhang:" + map.getOrDefault("Zhang", 0));
        System.out.println("Fu:" + map.getOrDefault("Fu", 0));
    }
}