package LeetCode.Main101_200;

public class Main0112 {
    public static int maxProfit(int[] prices) {
        int res = 0;
        int buyPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < buyPrice)
                buyPrice = prices[i];
            else if(prices[i] - buyPrice > res)
                res = prices[i] - buyPrice;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{1, 5}));
    }
}
