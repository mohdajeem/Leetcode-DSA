class Solution {
    public int maxRepeating(String sequence, String word) {
        int n = sequence.length(), m = word.length();
        int[] dp = new int[n+1];
        int max = 0;
        for(int i = m;i<=n;i++){
            if(sequence.substring(i-m, i).equals(word)){
                dp[i] = dp[i-m]+1;
                max = Math.max(dp[i], max);
            }
        }
        return max;
    }
}