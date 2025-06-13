class Solution {
    public int minimizeMax(int[] nums, int p) {
        int n = nums.length;
        Arrays.sort(nums);
        int l = 0, h = nums[n-1]-nums[0];
        int ans = 0;
        while(l<=h){
            int mid = l + (h-l)/2;
            if(pairsPoss(mid, nums, p)){
                ans = mid;
                h = mid-1;
            } else{
                l = mid+1;
            }
        }
        return ans;
    }
    public boolean pairsPoss(int mid, int[] nums, int p){
        int c = 0;
        for(int i =0;i<nums.length-1;i++){
            if(Math.abs(nums[i] - nums[i+1]) <= mid){
                c++;
                i++;
            }
        }
        return c >= p;
    }
}