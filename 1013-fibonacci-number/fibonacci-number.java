class Solution {
    public int fib(int n) {
        if(n == 1 || n == 0){
            return n;
        }
        int prev2 = 0;
        int prev = 1;
        int curr=prev+prev2;
        for(int i=2;i<=n;i++){
            curr = prev+prev2;
            prev2 = prev;
            prev = curr;
        }
        return curr;
    //    return fibRec(n, new int[n+1]);    
    }
    public int fibRec(int n, int[] dp){
        if(n == 1 || n == 0){
            return n;
        }
        if(dp[n] >0){
            return dp[n];
        }

        int nm1 = fibRec(n-1,dp);
        int nm2 = fibRec(n-2,dp);
        int com = nm1+nm2;
        dp[n] = com;
        return com;
    }
}