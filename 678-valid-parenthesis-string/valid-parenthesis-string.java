class Solution {
    public boolean checkValidString(String s) {
        int n = s.length();
        Boolean[][] dp = new Boolean[n][n];
        return fxn(0, 0, s,dp);
    }

    public boolean fxn(int ind, int count, String s, Boolean[][] dp) {
        if(count < 0) return false;
        if(ind == s.length()){
            return count == 0;
        }
        if(dp[ind][count]!= null) return dp[ind][count];
        if(s.charAt(ind) == '('){
            return dp[ind][count]=fxn(ind+1,count+1,s,dp);
        } else if(s.charAt(ind) == ')'){
            return dp[ind][count]=fxn(ind+1,count-1,s,dp);
        }

        return dp[ind][count]=fxn(ind+1,count+1,s,dp) || fxn(ind+1,count,s,dp) || fxn(ind+1,count-1,s,dp);
    }
}