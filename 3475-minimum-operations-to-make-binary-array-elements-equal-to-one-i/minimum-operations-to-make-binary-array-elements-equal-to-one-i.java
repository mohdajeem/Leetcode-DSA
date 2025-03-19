class Solution {
    public int minOperations(int[] nums) {
        if(nums.length<3) return 1;
        int l = 0, r = 2, n = nums.length;
        int c = 0;
        while(r<n){
            if(nums[l] == 0){
                for(int i = l;i<l+3;i++){
                    if(nums[i] == 0){
                        nums[i]=1;
                    }else{
                        nums[i]=0;
                    }
                }
                c++;
            }
            l++;
            r++;
        }
        for(int i =0;i<n;i++){
            if(nums[i] == 0) return -1;
        }
        return c;
    }
}