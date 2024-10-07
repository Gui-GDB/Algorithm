package LeetCode.Main1501_3000;

import java.util.Arrays;
import java.util.Scanner;

public class Main2491 {
    public static long dividePlayers(int[] skill) {
        Arrays.sort(skill);
        long sum = 0;
        int temp = skill[0] + skill[skill.length - 1];
        sum += (long) skill[skill.length - 1] * skill[0];
        for (int i = 1; i < skill.length / 2; i++) {
            if (temp != skill[i] + skill[skill.length - 1 - i])
                return -1L;
            sum += (long) skill[i] * skill[skill.length - 1 - i];
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] skill = new int[n];
        for (int i = 0; i < n; i++) {
            skill[i] = sc.nextInt();
        }
        System.out.println(dividePlayers(skill));
    }
}
