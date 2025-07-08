class Solution {
    public int maxProfit(int[] prices) {
        int mini = prices[0];
        int maxProfit = 0;
        for(int i = 1;i<prices.length;i++){
            int currPro = prices[i]-mini;
            maxProfit = Math.max(maxProfit, currPro);
            mini = Math.min(mini, prices[i]);
        }
        return maxProfit;
    }
}