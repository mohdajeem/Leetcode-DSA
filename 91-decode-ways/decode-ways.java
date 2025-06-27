class Solution {
    int[] dp;
    public int numDecodings(String s) {
        int n = s.length();
        dp = new int[n];
        Arrays.fill(dp,-1);
        return rec(0,s);
    }
    public int rec(int ind, String s){
        if(ind == s.length()) return 1;
        if(dp[ind] != -1) return dp[ind];
        int ways = 0;
        for(int i = 1;i<=2;i++){
            if(ind+i <= s.length()){
                String sub = s.substring(ind, ind+i);
                if(isValid(sub)){
                    ways += rec(ind+i, s);
                }
            }
        }
        return dp[ind] = ways;
    }
    private boolean isValid(String s){
        if(s.length() > 2) return false;
        if(s.length() == 2 && Integer.parseInt(s) < 10) return false;
        return Integer.parseInt(s) <= 26 && Integer.parseInt(s) >0;
    }
}