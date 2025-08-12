class Solution {
    public int characterReplacement(String s, int k) {
        int[] chArr = new int[26];
        int n = s.length(), l = 0, cntMax = 0, ans = 0;
        for(int r = 0;r<n;r++){
            chArr[s.charAt(r)-'A']++;
            cntMax = Math.max(cntMax, chArr[s.charAt(r)-'A']);
            while(r-l+1 - cntMax > k){
                chArr[s.charAt(l)-'A']--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }

        return ans;
    }
}