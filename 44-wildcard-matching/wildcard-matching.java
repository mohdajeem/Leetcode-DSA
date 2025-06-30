class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length(), m = p.length();
        Boolean[][] dp = new Boolean[m+1][n+1];
        return rec(0,0,p,s, dp);
    }
    public boolean rec(int i, int j, String p, String s, Boolean[][] dp){
        if(j == s.length() && i == p.length()){
            return true;
        }
        if(i == p.length()) return false;
        if(j == s.length()){
            for(int ind = i; ind <p.length();ind++){
                if(p.charAt(ind) != '*') return false;
            }
            return true;
        }
        if(dp[i][j] != null) return dp[i][j];
        if(p.charAt(i) == '*'){
            return dp[i][j]=rec(i,j+1,p,s, dp) || rec(i+1,j,p,s,dp);
        } else if(p.charAt(i) == '?'){
            return dp[i][j]=rec(i+1,j+1,p,s,dp);
        } else if(p.charAt(i) == s.charAt(j)) {
            return dp[i][j]=rec(i+1,j+1,p,s,dp);
        }
        return dp[i][j]=false;
    }
}