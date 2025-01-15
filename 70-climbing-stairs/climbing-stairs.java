class Solution {
    public int climbStairs(int n) {
        // return countStairs(n, new int[n+1]);
        return countStairsTab(n);
        
    }
    public int countStairs(int n, int[] qb){
        if(n == 0){
            return 1;
        } else if(n < 0){
            return 0;
        }

        if(qb[n] > 0){
            return qb[n];
        }
        int nm1 = countStairs(n-1,qb);
        int nm2 = countStairs(n-2, qb);
        int cb = nm1+nm2;
        qb[n] = cb;
        return cb;
    }
    public int countStairsTab(int n){
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i = 1;i<=n;i++){
            if(i == 1){
                dp[i] = 1;
            } else{
                dp[i] = dp[i-1]+dp[i-2];
            }
        }
        return dp[n];
    }
}