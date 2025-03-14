class Solution {
    public int maximumCandies(int[] candies, long k) {
        int maxi = Integer.MIN_VALUE;
        long sum=0;
        for(int i:candies){
            sum+=i;
            maxi = Math.max(maxi,i);
        }
        if(sum < k) return 0;
        int s = 1;
        int e = maxi, ans=0;
        while(s<=e){
            int mid = s+(e-s)/2;
            if(canAssign(candies,k,mid)){
                ans = mid;
                s = mid+1;
            } else{
                e = mid-1;
            }
        }
        return ans;
    }
    public boolean canAssign(int[] candies, long k, int s){
        for(int i : candies){
            k -= Math.floor((double) i/s);
        }
        return k <=0;
    }
}