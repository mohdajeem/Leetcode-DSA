class Solution {
    public int longestSubsequence(String s, int k) {
        int c = 0;
        int n = s.length();
        int pow = 1;
        for(int i = n-1;i>=0;i--){
            if(s.charAt(i) == '0') c++;
            else{
                if(k >= pow){
                    k -= pow;
                    c++;
                }
            }
            if(k >= pow){
                pow = 2*pow;
            }
        }
        return c;
    }
}