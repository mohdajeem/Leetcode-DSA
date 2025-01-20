class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int s = -1, e = -1;
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        
        for(int i = 0;i<n;i++){
            if(nums[i] < max){
                e = i;
            }else{
                max = nums[i];
            }
        }
        for(int i = n-1;i>=0;i--){
            if(nums[i] > min){
                s = i;
            } else{
                min = nums[i];
            }
        }

        if(s == -1){
            return 0;
        }
        return e - s + 1;
    }
}