class Solution {
    public int[] countBits(int n) {
        int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // memo(n, n, dp);
        // dp[0] = 0, dp[1] = 1, dp[2] = 1
        // dp[3] = dp[2]+1; -> it is odd
        // 2->1, 4-> 1, 6->2 8-> 1, 10->2, 
        if(n==0) return new int[]{n};
        dp[0]=0;
        dp[1]=1;
        for(int i = 2;i<=n;i++){
            if((i&1)==0){ // even
                if((i&(i-1)) == 0){ // it is 2^k
                    dp[i]=1;
                } else{
                    dp[i] = dp[i/2];
                }
            } else{
                dp[i] = dp[i-1]+1;
            }
        }
        return dp;
    }
}