class Solution {
    public int arrangeCoins(int n) {
        return rec(1, n);
    }
    public int rec(int i, int n){
        if(i > n) return 0;
        
        return 1 + rec(i+1, n-i);
    }
}