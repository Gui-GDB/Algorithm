package SZU.SimulationTest;
/*
题目描述
    在银行营业大厅共服务3种客户，类型为A\B\C，大厅分别设置了3个窗口分别服务三种客户，即每个窗口只服务一种客户。现有一批客户来银行办理业务，每个客户都有类型和办理业务时间。每个窗口按照客户到来的顺序进行服务。
    编程实现它们的办理流程，请使用C++自带的queue必须使用队列实现，其他方法0分！
    队列queue的用法如下：
        1.包含头文件：#include <queue>
        2.定义一个整数队列对象：queue<int>  myQe;
        3.定义一个整数队列对象数组：queue<int>  myQA[10];
        4.入队操作：myQe.push(itemp); //把整数itemp进入队列
        5.出队操作：myQe.pop();  //把队头元素弹出队列，注意本操作不获取队头元素
        6.获取队头元素： itemp = myQe.front(); // 把队头元素放入itemp中，注意本操作不弹出元素
        7.判断队列是否为空：myQe.empty();//队列空则返回true，不空则返回false
输入
    第一行输入先输入n表示客户数量
    第二行输入每个客户的类型，数据之间用用空格隔开
    第三行输入每个客户的办理时间，数据之间用用空格隔开
输出
    第一行输出A类客户的平均办理时间
    第二行输出B类客户的平均办理时间
    第三行输出C类客户的平均办理时间
输入样例：
    8
    A B C B C A A A
    10 20 30 40 50 60 70 80

输出样例：
    55
    30
    40

 */

import java.util.*;

public class MainG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Queue<String> q = new LinkedList<>();
        Map<String, Integer> customerMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String c = sc.next();
            q.add(c);
            customerMap.put(c, customerMap.getOrDefault(c, 0) + 1);
        }
        long A = 0, B = 0, C = 0;
        for (int i = 0; i < n; i++) {
            String c = q.poll();
            if ("A".equals(c))
                A += sc.nextLong();
            else if ("B".equals(c))
                B += sc.nextLong();
            else
                C += sc.nextLong();
        }
        System.out.println(A / customerMap.get("A"));
        System.out.println(B / customerMap.get("B"));
        System.out.println(C / customerMap.get("C"));
    }
}
