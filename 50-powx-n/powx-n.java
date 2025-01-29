class Solution {
    public double myPow(double x, int n) {
        double ans = 0;
        long N = (long) n;
        if(N<0){
            x = 1/x;
            // N = -N;
        }
        return fastSolve(x,N);
        // if(n > 0){
        //     ans = solvePos(x,N);
        // } else if(n < 0){
        //     ans = solveNeg(x,N);
        // } else{
        //     ans = 1;
        // }
        // return ans;
        
    }
    public double fastSolve(double x, long n){
        if(n == 0) return 1;
        double half = fastSolve(x, n/2);
        if(n%2 == 0) return half * half;
        else return half*half*x;
    }
    public double solvePos(double x, long n){
        if(n==1){
            return x;
        }
        return x*solvePos(x,n-1);
    }
    public double solveNeg(double x, long n){
        if(n== -1){
            return 1/x;
        }
        return (1/x)*solveNeg(x, n+1);
    }
    
}