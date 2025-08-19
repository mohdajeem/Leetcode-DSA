class Solution {
    public long zeroFilledSubarray(int[] nums) {
        int n = nums.length;
        int i=0,j=0;
        long ans = 0;
        for(i=0;i<n;i++){
            if(nums[i] == 0) break;
        }
        if(i == n) return 0;
        while(j<n){
            if(nums[j]==0){
                ans+=(j-i+1);
                j++;
            } else{
                while(j<n && nums[j] != 0){
                    j++;
                }
                i=j;
            }
        }
        return ans;
    }
}