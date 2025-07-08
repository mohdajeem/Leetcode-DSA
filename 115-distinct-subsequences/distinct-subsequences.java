class Solution {
    public int numDistinct(String s, String t) {
        int n = s.length(), m = t.length();
        int[][] dp = new int[n+1][m+1];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        return rec(0,0, s, t, dp);
    }
    public int rec(int i, int j, String s, String t, int[][] dp){
        if(j == t.length()) return 1;
        if(i == s.length()) return 0;
        if(dp[i][j] != -1) return dp[i][j];
        int notTake = rec(i+1, j, s, t, dp);
        int take = 0;
        if(s.charAt(i) == t.charAt(j)){
            take = rec(i+1,j+1, s, t, dp);
        }
        return dp[i][j] = take + notTake;
    }
}