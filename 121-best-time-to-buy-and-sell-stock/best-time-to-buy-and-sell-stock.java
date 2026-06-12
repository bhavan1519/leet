class Solution {
    public int maxProfit(int[] prices) {
        int low = prices[0];
        int high = 0;
        for (int i = 1; i < prices.length; i++) {
            low = Math.min(low,prices[i]);
            high = Math.max(high, prices[i] - low);
        }
        return high;          
    }
}