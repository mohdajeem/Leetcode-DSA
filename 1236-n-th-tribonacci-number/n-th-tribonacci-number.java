class Solution {
    public int tribonacci(int n) {
        return tribonacciRec(n, new int[n+1]);
    }
    public int tribonacciRec(int n, int[] dp){
        if(n == 0 || n == 1){
            return n;
        } else if(n == 2){
            return 1;
        }

        if(dp[n] > 0) return dp[n];

        int nm1 = tribonacciRec(n-1, dp);
        int nm2 = tribonacciRec(n-2, dp);
        int nm3 = tribonacciRec(n-3, dp);
        int comb = nm1+nm2+nm3;
        dp[n] = comb;
        return comb;
    }
}