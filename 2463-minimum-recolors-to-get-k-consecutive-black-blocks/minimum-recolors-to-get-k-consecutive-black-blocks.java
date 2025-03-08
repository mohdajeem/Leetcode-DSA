class Solution {
    public int minimumRecolors(String blocks, int k) {
        int l = 0, r=0,c=0;
        for(int i=0;i<k;i++){
            if(blocks.charAt(i)=='W'){
                c++;
            }
            r++;
        }
        int ans = c;
        while(r<blocks.length()){
            if(blocks.charAt(l) == 'W'){
                c--;
            }
            if(blocks.charAt(r)=='W') c++;
            ans = Math.min(c,ans);
            l++;
            r++;
        }
        return ans;
    }
}