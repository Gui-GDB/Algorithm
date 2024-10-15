package LeetCode.Main101_200;

import java.util.ArrayList;
import java.util.List;

public class Main0119 {
    /**
     * 时间复杂度O(n^2)
     * 空间复杂度O(n)
     */
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1; j--) {
                list.set(j, list.get(j - 1) + list.get(j));
            }
            list.add(1);
        }
        return list;
    }

    public static void main(String[] args) {
        System.out.println(getRow(3));
    }
}
