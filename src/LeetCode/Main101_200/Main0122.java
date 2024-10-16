package LeetCode.Main101_200;

public class Main0122 {
    public static int maxProfit(int[] prices) {
        int n = prices.length, price = prices[0];
        int res = 0;
        for (int i=1; i < n; i++) {
            if (prices[i] > price)
                res += prices[i] - price;
            price = prices[i];
        }
        return res;
    }
}
