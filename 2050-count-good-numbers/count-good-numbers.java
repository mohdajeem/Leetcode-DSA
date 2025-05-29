class Solution {
    int M = (int)1e9+7;
    // public int countGoodNumbers(long n) {
    //     return rec(n-1)%M;
    // }
    // public int rec(long n){
    //     if(n==0) return 5;
    //     if(n%2==0) return 5*rec(n-1)%M;
    //     return 4*rec(n-1)%M;
    // }
    public int countGoodNumbers(long n) {
        long even = (n+1)/2;
        long odd = n/2;
        long ev = pow(5,even);
        long od = pow(4,odd);
        int ans = (int)((ev*od)%M);
        return ans;
    }

    public long pow(int x, long n){
        if(n==0) return 1;
        if(n==1) return x;
        long half = pow(x,n/2);
        long res = (half*half)%M;
        if(n%2 != 0){
            res = (((long)res*x)%M);
        }
        return res;
    }

}