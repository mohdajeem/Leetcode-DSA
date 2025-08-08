class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        return tabu(word1, word2, n, m);
        // int[][] dp = new int[n][m];
        // for(int[] ar : dp) Arrays.fill(ar, -1);
        // return rec(word1, word2, 0,0, dp);
    }
    public int tabu(String word1, String word2, int n, int m){
        int[][] dp = new int[n+1][m+1];
        for(int j = 0;j<=m;j++){
            dp[n][j]=m-j;
        }
        for(int i =0;i<=n;i++){
            dp[i][m] = n-i;
        }

        for(int i = n-1;i>=0;i--){
            for(int j = m-1;j>=0;j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                } else{
                    dp[i][j] = 1 + Math.min(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[0][0];
    }
    public int rec(String word1, String word2, int i, int j, int[][] dp){
        if(i == word1.length()){
            return word2.length()-j;
        }
        if(j == word2.length()) return word1.length()-i;
        if(dp[i][j] != -1) return dp[i][j];
        if(word1.charAt(i) == word2.charAt(j)){
            return dp[i][j]= rec(word1, word2, i+1,j+1, dp);
        }

        return dp[i][j]= 1 + Math.min(rec(word1, word2, i+1, j,dp), rec(word1, word2, i, j+1,dp));
    }
}