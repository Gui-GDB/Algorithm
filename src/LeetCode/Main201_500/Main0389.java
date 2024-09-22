package LeetCode.Main201_500;

import java.util.Scanner;

public class Main0389 {

    /**
     * 解题思路：
     * 先后遍历两个字符串，然后统计各个字符出现的次数即可。
     * 时间复杂度O(n)
     *
     * @param s 元素字符串
     * @param t 重新排序后并且插入了一个字符的字符串
     * @return 返回多出来的字符
     */
    public static char findTheDifference(String s, String t) {
        int[] arr = new int[26];
        char[] charArray_s = s.toCharArray();
        char[] charArray_t = t.toCharArray();

        for (char charArray : charArray_s) arr[charArray - 'a']++;

        for (char c : charArray_t) arr[c - 'a']--;

        for (int i = 0; i < 26; i++)
            if (arr[i] != 0)
                return (char) (i + 'a');
        return ' ';
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String t = sc.nextLine();
        System.out.println(findTheDifference(s, t));
    }
}
