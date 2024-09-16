package LeetCode.Main1_100;

import java.util.Scanner;

public class Main0008 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(myAtoi(s));
    }

    /**
     * 解题思路：
     * ① 将读取的字符串去除前后空白;
     * ② 检查第一个字符，判断该数字是正数还是负数;
     * ③ 清除前置 0 后再读取整数，如果读取到非数字或者到达字符串的结尾则结束。(在读取的过程中就可以解决，不用单独处理)
     * ④ 判断当前整数是否溢出了Integer的范围。
     * ⑤ 结果默认为 0.
     * 复杂度：
     * 空间复杂度：O(1)
     * 时间复杂度：O(n)
     *
     * @param s 需要转化为整数的字符串
     * @return 返回得到的整数
     */
    public static int myAtoi(String s) {
        long ans = 0;
        // 去除前面的空白
        String temp = s.trim();
        if (temp.isEmpty()) {
            return 0;
        }
        // 判断是正数还是负数
        int flag = 1; // 标志当前的数是正数还是负数，默认就是正数。
        if (temp.charAt(0) == '-') {
            temp = temp.substring(1);
            flag = -1;
        } else if (temp.charAt(0) == '+') {
            temp = temp.substring(1);
        }
        for (int i = 0; i < temp.length(); i++) {
            char c = temp.charAt(i);
            if (c >= '0' && c <= '9') {
                //溢出情况处理
                if (flag == 1 && ans * 10 + c - '0' > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if ((ans * 10 + c - '0') * -1 < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
                ans = ans * 10 + (c - '0');
            } else
                return (int) ans * flag;
        }
        return (int) ans * flag;
    }
}
