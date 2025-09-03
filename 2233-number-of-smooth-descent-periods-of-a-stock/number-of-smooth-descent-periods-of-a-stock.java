class Solution {
    public long getDescentPeriods(int[] prices) {
        int n = prices.length, i =0, j =0;
        long ans =0;
        while(j<n){
            if(prices[i]-prices[j] != j-i){
                i = j;
            }
            ans+=(j-i+1);
            j++;
        }
        return ans;
    }
}