class Solution {
    public int[] applyOperations(int[] nums) {
        for(int i =0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                nums[i] = 2*nums[i];
                nums[i+1]=0;
            }
        }
        System.out.println(Arrays.toString(nums));
        int j =0;
        for(int i =0;i<nums.length;i++){
            if(nums[i]!=0){
                System.out.println(nums[i]);
                nums[j]=nums[i];
                if(i!=j) nums[i]=0;
                j++;
            }
        }
        return nums;
    }
}