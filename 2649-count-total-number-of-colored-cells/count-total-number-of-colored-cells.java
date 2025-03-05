class Solution {
    public long coloredCells(int n) {
        long last = 1;
        for(int i =1;i<=n;i++){
            last=last+(i-1)*4;
        }
        return last;
    }
}