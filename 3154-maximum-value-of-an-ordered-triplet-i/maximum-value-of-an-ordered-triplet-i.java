class Solution {
    public long maximumTripletValue(int[] nums) {
        long ans = 0;
        int n = nums.length;
        for(int i =0;i<n;i++){
            for(int j =i+1;j<n;j++){
                for(int k = j+1;k<n;k++){
                    Long val = (long) (nums[i]-nums[j])*nums[k];
                    if(val <0) val = (long)0;
                    ans = Math.max(ans,val);
                }
            }
        }
        return ans;
    }
}