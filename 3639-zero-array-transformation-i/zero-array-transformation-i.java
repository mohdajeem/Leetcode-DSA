class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n+1];
        for(int i =0;i<queries.length;i++){
            int l = queries[i][0];
            int r = queries[i][1];
            diff[l]-=1;
            diff[r+1]+=1;
        }
        for(int i =1;i<diff.length;i++){
            diff[i] += diff[i-1];
        }
        for(int i = 0;i<n;i++){
            nums[i]+=diff[i];
            if(nums[i] > 0) return false;
        }
        return true;
    }
}