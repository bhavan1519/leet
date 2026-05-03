class Solution {
    public int maxProfit(int[] prices) {
        int buy = prices[0];
        int pro = 0;
        for (int i = 1; i < prices.length; i++) {
            if (buy > prices[i]) {
                buy = prices[i];
            }
            pro = Math.max(pro, prices[i] - buy);
        }
        return pro;          
    }
}