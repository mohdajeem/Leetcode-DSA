class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k<=0) return false;
        int n = nums.length;
        HashSet<Integer> set = new HashSet<>();
        int i = 0, j =1;
        set.add(nums[i]);
        while(j<n){
            if(set.contains(nums[j])) return true;
            set.add(nums[j]);
            j++;
            if(Math.abs(j-i)>k){
                set.remove(nums[i]);
                i++;
            }
        }
        return false;

    }
}