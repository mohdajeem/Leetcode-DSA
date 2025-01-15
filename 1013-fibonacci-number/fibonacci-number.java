class Solution {
    public int fib(int n) {
       return fibRec(n, new int[n+1]);    
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