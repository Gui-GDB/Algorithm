package LeetCode.Main1_100;

import java.util.*;

public class Main_0006 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int numRows = sc.nextInt();
        System.out.println(convert(s, numRows));
    }

    /**
     * 主要是找到题目中的规律，如果是三行(PAYPALISHIRING)，你数123212321...你就会发现你数的过程中就已经将这个题目做完了。2024-9-13
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     *
     * @param s       需要处理的字符串数据
     * @param numRows 数据应该已几行的方式来读取
     * @return 返回按照指定顺序的字符串
     */
    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length()) {
            return s; // 特殊情况：只有一行或者字符串长度小于行数，直接返回原字符串
        }
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder(); // 初始化每一行的 StringBuilder
        }
        int currentRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c); // 将字符追加到当前行
            // 如果到达顶部或底部，则改变方向
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }
        // 将所有行的内容拼接成最终结果
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        return result.toString();
    }
}
