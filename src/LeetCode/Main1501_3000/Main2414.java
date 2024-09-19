package LeetCode.Main1501_3000;

import java.util.Scanner;

public class Main2414 {
    /**
     * 遍历字符串，当前字符 + 1看看后后面一个字符是否相同，如果相同这表明是连续的，否则不是连续的。
     * 遍历过程中记录当前发现的最长字母序连续字符串
     *
     * @param s 待处理的字符串
     * @return 最长的字母序连续子字符串的长度。
     */
    public static int longestContinuousSubstring(String s) {
        int res = 1, temp = 1;
        char[] charArray = s.toCharArray();
        for (int i = 0; i < s.length() - 1; i++) {
            if (charArray[i] + 1 == charArray[i + 1]) {
                res = Math.max(res, ++temp);
            } else {
                temp = 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(longestContinuousSubstring(s));
    }
}
