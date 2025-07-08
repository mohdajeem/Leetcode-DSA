class Solution {
    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a,b) -> a[0]-b[0]);
        int[][] dp = new int[events.length][k+1];
        for(int[] ar : dp) Arrays.fill(ar, -1);
        return rec(0, events, k, dp);
    }
    public int rec(int ind, int[][] events, int k, int[][] dp){
        if(ind == events.length) return 0;
        if(k == 0) return 0;
        if(dp[ind][k] != -1) return dp[ind][k];
        int notTake = rec(ind+1, events, k, dp);
        int nextEvent = BS(events[ind][1], events);
        int take = events[ind][2] + rec(nextEvent, events, k-1, dp);

        return dp[ind][k] = Math.max(notTake, take);
    }

    public int BS(int target, int[][] events){
        int s = 0, e = events.length-1;
        int ans = events.length;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(events[mid][0] > target){
                ans = mid;
                e = mid-1;
            } else{
                s = mid+1;
            }
        }
        return ans;
    }

}