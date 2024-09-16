package LeetCode.Main1_100;

import java.util.Scanner;

public class Main0007 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(reverse(x));
    }

    /**
     * 解题思路：由于不能使用long数据类型，考虑利用字符串的方式进行
     * ① 如果读取的字符数的位数比整数的最大值位数少，那么则直接翻转就可以了。
     * ② 如果读取的字符数的位数和整数的最大值位数一样，需要将最后一位和第一位进行比较，如果大于则返回0，以此类推第二位和倒数第二位。
     * todo 写的偏复杂了一点
     *
     * @param x 需要翻转的整数。
     */
    public static int reverse(int x) {
        int op = (x > 0 ? 1 : -1);  //保留当前读取的数是整数还是负数
        x = Math.abs(x);
        int flag = x / 1000000000;
        int res = 0;
        String intMaxVal = String.valueOf(Integer.MAX_VALUE); //最大值
        //需要每个位置进行匹配
        if (flag != 0) {
            String s = String.valueOf(x);
            for (int i = 0; i < intMaxVal.length(); i++) {
                char c = s.charAt(intMaxVal.length() - 1 - i);
                if (intMaxVal.charAt(i) > c) {
                    break;
                } else if (intMaxVal.charAt(i) < c) {
                    return 0;
                }
            }
        }
        //将读取的整数进行翻转
        while (x != 0) {
            int temp = x % 10;
            res = res * 10 + temp;
            x = x / 10;
        }
        return res * op;
    }
}
