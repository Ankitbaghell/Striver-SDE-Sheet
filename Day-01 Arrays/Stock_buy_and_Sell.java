
public class Stock_buy_and_Sell {
    class Solution {
        public int maxProfit(int[] prices) {
            int minPrice = prices[0];
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] < minPrice) // finding minimum price to buy
                    minPrice = prices[i];
                int cost = prices[i] - minPrice;
                profit = Math.max(profit, cost); // profit if I sell on i-th day
            }
            return profit;
        }
    }
}
