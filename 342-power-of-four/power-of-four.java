class Solution {
    public boolean isPowerOfFour(int n) {
        if(n==0) return false;
        return ((n&(n-1)) == 0) && ((findPos(n)%2!=1));
    }
    public int findPos(int n){
        if(n == 0) return 0;
        int pos=0;
        while((n&1) ==0){
            n >>= 1;
            pos++;
        }
        return pos;
    }
    // public boolean isPower(int n){
    //     if(n == 1) return true;
    //     if(n < 4)  return false;

    //     return n%4 == 0 && isPower(n/4);
    // }
}