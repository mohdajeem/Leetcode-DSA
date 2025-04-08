class Solution {
    public int minimumOperations(int[] nums) {
        int ans =0;
        for(int i =0;i<nums.length;i+=3){
            if(check(nums,i)){
                return ans;
            }
            ans++;
        }
        return ans;
    }
    public boolean check(int[] nums, int start){
        HashSet<Integer> set = new HashSet<>();
        for(int i = start;i<nums.length;i++){
            if(set.contains(nums[i])){
                return false;
            }
            set.add(nums[i]);
        }
        return true;
    }
}