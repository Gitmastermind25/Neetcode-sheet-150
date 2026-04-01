package slidingwindow;

import java.util.*;

public class BuyTimeSellStock {

    public int maxProfit(int[] prices) {
        int maxP = 0;
        int minBuy = prices[0];

        for (int sell : prices) {
            maxP = Math.max(maxP, sell - minBuy);
            minBuy = Math.min(minBuy, sell);
        }
        return maxP;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input size
        System.out.print("Enter number of days: ");
        int n = sc.nextInt();

        int[] prices = new int[n];

        // Input prices
        System.out.println("Enter stock prices:");
        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        BuyTimeSellStock obj = new BuyTimeSellStock();
        int result = obj.maxProfit(prices);

        System.out.println("Maximum Profit: " + result);
    }
}