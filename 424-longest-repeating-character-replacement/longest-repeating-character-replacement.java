class Solution {
    public int characterReplacement(String s, int k) {
        int maxCount = 0, l = 0;
        int[] ch = new int[26];
        char[] chArr = s.toCharArray();
        int ans = 0;
        for(int r = 0; r<chArr.length;r++){
            ch[chArr[r] -'A']++;
            maxCount = Math.max(maxCount, ch[chArr[r]-'A']);
            while((r-l+1 - maxCount) > k){
                ch[chArr[l]-'A']--;
                l++;
            }
            ans = Math.max(ans, r-l+1);
        }
        return ans;
    }
}