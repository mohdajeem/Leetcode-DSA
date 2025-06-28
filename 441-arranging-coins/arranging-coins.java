class Solution {
    public int arrangeCoins(int n) {
        long l = 0, h = n;
        while(l<=h){
            long mid = l+(h-l)/2;
            long val = (mid*(mid+1))/2;
            if(val == n) return (int) mid;
            else if(val > n) h = mid-1;
            else l = mid+1;
        }
        return (int)h;

        /*
        long sqt = sqrt((long)(8*n+1));
        // int res = (int)Math.min(Math.abs((-1+sqt)/2), Math.abs((-1-sqt)/2));
        int res = (int) Math.floor((Math.abs((-1+sqt)/2)));
        return res;
        */
    }
    /*
    public long sqrt(long n){
        long s = 1, e = n/2;
        long ans = 0;
        while(s <= e){
            long mid = s + (e-s)/2;
            if(mid*mid <= n){
                ans = mid;
                s = mid+1;
            } else{
                e = mid-1;
            }
        }
        return ans;
    }
    */
}