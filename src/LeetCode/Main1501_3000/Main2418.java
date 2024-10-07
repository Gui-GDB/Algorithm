package LeetCode.Main1501_3000;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main2418 {

    /**
     * 解题思路：
     * 首先将身高和对应的下标存入到HashMap中(身高，下标)
     * 将身高按照升序的循序排序，然后从后往前遍历，依次查找HashMap得到对应的原始下标
     */
    public static String[] sortPeople(String[] names, int[] heights) {
        String[] res = new String[names.length];
        int length = heights.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < length; i++)
            map.put(heights[i], i);
        Arrays.sort(heights);
        for (int i = length - 1; i >= 0; i--)
            res[length - i - 1] = names[map.get(heights[i])];
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] names = new String[n];
        int[] heights = new int[n];
        for (int i = 0; i < n; i++) {
            names[i] = sc.next();
            heights[i] = sc.nextInt();
        }
        System.out.println(Arrays.toString(sortPeople(names, heights)));
    }
}
