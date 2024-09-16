package LeetCode.Main1_100;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main0003 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 解题思路：
     *      遍历字符串的每一个字符，并且判断该字符在当前截取的字符串中是否已经存在。
     *      如果已经存在那个将当前截取的字符串的起始位置设置为上一次出现的位置。
     * 复杂度分析：
     *      时间复杂度：O(n)
     *      空间复杂度为O(m)，m为最大满足条件的字符数。
     * @param s 需要处理的字符串
     */
    public static int lengthOfLongestSubstring(String s) {
        // key保存出现的字符，value保存当前字符出现的下标，便于快速定位
        Map<Character, Integer> map = new HashMap<>();
        int max = 0; //记录当前寻找到的最长子字符串的最大长度
        int start = 0; //记录当前截取的子字符串的起始位置
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                max = Math.max(max, i - start);
                int index = map.get(s.charAt(i));
                while (start <= index) {
                    map.remove(s.charAt(start++));
                }
                map.put(s.charAt(i), i);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        //最后判断当前的字符串长度和最大长度那个大
        max = Math.max(max, map.size());
        return max;
    }
}
