class Solution {
    public int longestStrChain(String[] words) {
        Arrays.sort(words, (a,b) -> Integer.compare(a.length(), b.length()));
        // System.out.println(Arrays.toString(words));
        int n = words.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int max = 0;
        for(int i =0;i<n;i++){
            for(int j = 0;j<i;j++){
                if(isPred(words[i], words[j])){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    public boolean isPred(String s1, String s2){
        int n = s1.length(), m = s2.length();
        if(( n - m > 1) || (n - m == 0)) return false;
        int i =0, j =0;
        while(i<n){
            if(j < m && s1.charAt(i) == s2.charAt(j)){
                i++;
                j++;
            }
            else{
                i++;
            }
        }
        return j == m;
    }
}