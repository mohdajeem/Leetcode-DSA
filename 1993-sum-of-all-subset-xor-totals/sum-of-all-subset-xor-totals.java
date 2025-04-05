class Solution {
    int total = 0;
    public int subsetXORSum(int[] nums) {
        // int n = nums.length;
        rec(0,nums,0);
        return total;
    }
    public void rec(int ind, int[] nums,int currentXor){
        if(ind==nums.length){
            total+=currentXor;
            return; 
        }
        rec(ind+1,nums, currentXor^nums[ind]);
        rec(ind+1,nums,currentXor);
    }
}