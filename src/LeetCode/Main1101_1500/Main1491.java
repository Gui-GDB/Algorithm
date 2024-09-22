package LeetCode.Main1101_1500;

public class Main1491 {
    /**
     * 解题思路：
     * 遍历工资数组，记录最大值和最小值即可。
     *
     * @param salary 工资数组
     * @return 除去最大值和最小值的平均工资
     */
    public static double average(int[] salary) {
        double sum = 0;
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int j : salary) {
            sum += j;
            min = Math.min(min, j);
            max = Math.max(max, j);
        }
        sum = sum - min - max;
        return sum / (salary.length - 2);
    }
}
