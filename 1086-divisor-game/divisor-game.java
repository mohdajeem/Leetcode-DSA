class Solution {
    public boolean divisorGame(int n) {
        // return (n&1) == 0;
        return rec(n, 0);
    }
    public boolean rec(int n, int p){
        if(n == 1){
            if(p == 0) return false;
            return true;
        }
        if(n == 2){
            if(p==0) return true;
            return false;
        }
        return p == 1 ? rec(n-1, 0) : rec(n-1, 1);
    }

}