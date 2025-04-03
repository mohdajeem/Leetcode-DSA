class Solution {
    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] prefixMax = new int[n];
        int[] suffixMax = new int[n];
        int Lmax = nums[0];
        for(int i =0;i<n;i++){
            if(nums[i] > Lmax){
                Lmax = nums[i];
            }
            prefixMax[i] = Lmax;
        }
        int Rmax = nums[n-1];
        for(int i =n-1;i>=0;i--){
            if(nums[i] > Rmax){
                Rmax = nums[i];
            }
            suffixMax[i] = Rmax;
        }
        long maxAns = 0;
        for(int i =1;i<n-1;i++){
            long val = (long) (prefixMax[i-1]-nums[i])*suffixMax[i+1];
            maxAns = Math.max(maxAns,val);
        }
        return maxAns;
    }
}