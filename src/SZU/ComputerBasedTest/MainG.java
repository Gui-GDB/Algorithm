package SZU.ComputerBasedTest;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/*
题目描述
    输入两组整数(每行不超过20个整数，每组整数中元素（有可能重复）。
    合并两组整数，去掉在两组整数中重复的元素(只保留单个元素)，并按从大到小的降序排序输出，这又称为整数集异或运算
    提示：合并后的整数集合不会存在重复的元素
输入
    首先输入第一组整数的个数，然后在下一行输入第一组整数，以一个空格分隔各个整数；然后以同样的方式输入第二组整数。
输出
    按从大到小顺序排序输出合并后的整数集
输入样例1：
    5
    1 3 5 7 9
    5
    2 3 4 5 6
输出样例1：
    9 7 6 5 4 3 2 1
输入样例2：
    3
    3 3 2
    4
    1 1 1 1
输出样例3：
    3 2 1
 */
public class MainG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            set.add(sc.nextInt());
        }
        Object[] array = set.toArray();
        Arrays.sort(array);
        for (int i = array.length - 1; i >= 0; i--) {
            System.out.print(array[i] + " ");
        }
    }
}