class Solution {
    public long distributeCandies(int n, int limit) {
        long ways = 0;
        int min1 = Math.max(0,n-2*limit);
        int max1 = Math.min(n, limit);
        for(int i = min1; i<= max1;i++){
            int N = n-i;
            int min2 = Math.max(0,N-limit);
            int max2 = Math.min(N, limit);
            ways += (max2 - min2 + 1);
        }
        return ways;
    }
}