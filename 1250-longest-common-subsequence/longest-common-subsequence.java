class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // return rec(0,0, text1, text2);
        return tabulation(text1, text2);
    }
    public int tabulation(String t1, String t2){
        int n = t1.length(), m = t2.length();
        int[][] dp = new int[n+1][m+1];
        for(int i = 1;i<=n;i++){
            for(int j = 1;j<=m;j++){
                if(t1.charAt(i-1) == t2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
    public int rec(int i, int j, String t1, String t2){
        if(i == t1.length() || j == t2.length()) return 0;
        
        if(t1.charAt(i) == t2.charAt(j)){
            return 1 + rec(i+1, j+1, t1, t2);
        }

        return Math.max(rec(i+1, j, t1, t2), rec(i, j+1, t1, t2));
    }
}