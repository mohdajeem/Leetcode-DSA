class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        if(nums.length == 0 || indexDiff == 0){
            return false;
        }
        TreeSet<Long> set = new TreeSet<>();
        for(int i =0;i<nums.length;i++){
            Long floor = set.floor( (long)(nums[i]+valueDiff));
            Long ceil = set.ceiling((long) (nums[i] -valueDiff));
            if((floor != null && floor>=nums[i]) || (ceil != null && ceil <= nums[i])){
                return true;
            }
            set.add(1L * nums[i]);
            if(i>=indexDiff){
                set.remove(1L * nums[i-indexDiff]);
            }
        }   
        return false;
    }
}