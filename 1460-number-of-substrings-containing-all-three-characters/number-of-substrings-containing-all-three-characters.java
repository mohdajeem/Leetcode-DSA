class Solution {
    public int numberOfSubstrings(String s) {
        int len = s.length(), ans = 0;
        int[] lastPos = {-1,-1,-1};
        for(int i =0;i<len;i++){
            lastPos[s.charAt(i) - 'a'] = i;
            int min = Math.min(lastPos[0], Math.min(lastPos[1],lastPos[2]));
            ans+=min+1;
        }
        return ans;
    }
}