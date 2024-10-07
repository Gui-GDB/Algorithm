package LeetCode.Main1101_1500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Main1331 {

    /**
     * 解题思路：
     * 首先复制一个新的数组将这个数组进行排序，然后将数组中的每个元素存入到hashmap中（排序后的元素，序号），
     * 然后遍历原始数组的每个元素在hashmap中查找到排序后的序号。
     * 复杂度分析：
     * 空间复杂度：O(n)
     * 时间复杂度：排序O(nlog n) + 查找hash表O(1) + 遍历数组元素O(n),时间复杂度为O(nlog n)
     */
    public static int[] arrayRankTransform(int[] arr) {
        int[] copyArr = Arrays.copyOf(arr, arr.length);
        Arrays.sort(copyArr);
        HashMap<Integer, Integer> map = new HashMap<>();
        int index = 1;
        int temp = Integer.MAX_VALUE;
        for (int value : copyArr) {
            if (temp != value) {
                temp = value;
                map.put(temp, index);
                index++;
            }
        }
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = map.get(arr[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] res = arrayRankTransform(arr);
        System.out.println(Arrays.toString(res));
    }
}
