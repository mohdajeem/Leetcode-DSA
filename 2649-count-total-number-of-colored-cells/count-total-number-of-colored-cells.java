class Solution {
    public long coloredCells(int n) {
        long ans = 0;
        long last = 1;
        for(int i =1;i<=n;i++){
            ans=last+(i-1)*4;
            last = ans;
        }
        return ans;
    }
}