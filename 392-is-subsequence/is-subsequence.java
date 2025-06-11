class Solution {
    public boolean isSubsequence(String s, String t) {
        Boolean[][] dp = new Boolean[s.length()][t.length()];
        return rec(0, 0, s, t, dp);
    }
    public boolean rec(int i, int j, String s, String t, Boolean[][] dp){
        if(i == s.length()) return true;
        if(j== t.length()) return false;
        if(dp[i][j] != null) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j]=rec(i+1,j+1,s,t,dp);
        }
        return dp[i][j] = rec(i, j+1, s, t,dp);
    }
}