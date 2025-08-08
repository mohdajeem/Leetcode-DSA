class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length(), m = word2.length();
        int[][] dp = new int[n][m];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        return rec(word1, word2, 0,0, dp);
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