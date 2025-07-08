class Solution {
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        return rec(0,0,word1, word2, dp);
    }
    public int rec(int i, int j, String s, String t,int[][] dp){
        if(j == t.length()) return s.length() - i;
        if(i == s.length()) return t.length()-j;
        if(dp[i][j] != -1) return dp[i][j];
        if(s.charAt(i) == t.charAt(j)){
            return dp[i][j] = rec(i+1, j+1, s, t, dp);
        }
        int replace = 1 + rec(i+1, j+1, s, t, dp);
        int delete = 1 + rec(i+1, j, s, t, dp);
        int insert = 1 + rec(i, j+1, s,t, dp);

        return dp[i][j] = Math.min(delete, Math.min(replace, insert));
    }
}