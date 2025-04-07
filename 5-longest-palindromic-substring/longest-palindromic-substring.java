class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for(int[] ar : dp){
            Arrays.fill(ar, -1);
        }
        int maxLen = 0;
        int ps = 0;
        for(int i =0;i<n;i++){
            for(int j =i;j<n;j++){
                if(isPalindrome(i,j,s,dp)){
                    if((j-i+1) > maxLen){
                        maxLen = j-i+1;
                        ps = i;
                    }
                }
            }
        }
        System.out.println(n+" "+ ps+" " +maxLen+" "+(maxLen+ps));
        return s.substring(ps, maxLen+ps);
        // return " ";
    }
    public boolean isPalindrome(int i, int j, String s,int[][] dp){
        if(i >= j) {
            return true;
        }
        if(dp[i][j] != -1){
            return dp[i][j] == 0 ? false : true;
        }
        if(s.charAt(i) == s.charAt(j)){
            boolean ans = isPalindrome(i+1,j-1,s, dp);
            dp[i][j] = ans == true ? 1 : 0;
            return ans;
        }
        dp[i][j] = 0;
        return false;
    }
}