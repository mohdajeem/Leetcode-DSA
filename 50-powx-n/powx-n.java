class Solution {
    public double myPow(double x, int n) {
        // return rec(x,n);
        if(n<0) return rec(1/x,n);
        return rec(x,n);

    }
    public double rec(double x, int n){
        if(n==0) return 1;
        if(n == 1) return x;
        double half = rec(x, n/2);
        double res = half*half;
        if((n&1) != 0) res = res * x;
        return res;
    }
}