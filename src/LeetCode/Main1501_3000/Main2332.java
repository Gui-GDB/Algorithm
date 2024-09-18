package LeetCode.Main1501_3000;

import algorithmTemplate.Sort;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Main2332 {
    /**
     * 解题思路：
     * 首先对buses和passengers进行升序排序，遍历buses首先假设当前公交车是最后一班，我的最晚上车时间；计算出我的最晚上公交的时间。
     * 然后将满足条件的乘客送走，循环直到最后一班公交车发车就知道我坐上公交的最晚时间。
     *
     * @param buses      公交车发车发车时刻表
     * @param passengers 乘客到达的时刻表
     * @param capacity   每辆公交车能够载的乘客数
     * @return 返回坐上公交的最晚时间
     */
    public static int latestTimeCatchTheBus(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int index = 0;
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < buses.length; i++) {
            int num = 0;
            while (num < capacity && index < passengers.length && buses[i] >= passengers[index]) {
                set.add(passengers[index]);
                index++;
                num++;
            }
            int last_time = i == 0 ? 0 : buses[i - 1];
            for (int j = buses[i]; j > res; j--) {
                if (!set.contains(j)) {
                    if (num < capacity) {
                        res = j;
                        break;
                    }
                    if (j < passengers[index - 1]) {
                        res = j;
                        break;
                    }
                }
            }
        }
        return res;
    }

    /**
     * 解题思路：
     * 再上面的思路上可以改进一下，不用没一班公交都去寻找最合适的时间，我直接将所有能够走的时间都先拿出来。
     * 然后从最后一班公交开始寻找适合我走的时间。
     *
     * @param buses      公交车发车发车时刻表
     * @param passengers 乘客到达的时刻表
     * @param capacity   每辆公交车能够载的乘客数
     * @return 返回坐上公交的最晚时间
     */
    public static int latestTimeCatchTheBus2(int[] buses, int[] passengers, int capacity) {
        Arrays.sort(buses);
        Arrays.sort(passengers);
        int index = 0, num = 0;
        for (int bus : buses) {
            num = 0;
            while (num < capacity && index < passengers.length && bus >= passengers[index]) {
                index++;
                num++;
            }
        }
        index--;
        int res = num == capacity ? passengers[index] : buses[buses.length - 1];
        while (index >= 0 && passengers[index] == res) {
            index--;
            res--;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int capacity = sc.nextInt();
        int[] buses = new int[n];
        int[] passengers = new int[m];
        for (int i = 0; i < n; i++) {
            buses[i] = sc.nextInt();
        }
        for (int i = 0; i < m; i++) {
            passengers[i] = sc.nextInt();
        }
        System.out.println(latestTimeCatchTheBus(buses, passengers, capacity));
    }
}
