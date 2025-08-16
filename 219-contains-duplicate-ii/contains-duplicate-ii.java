class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int j = 0;j<n;j++){
            if(map.containsKey(nums[j])){
                if(j-map.get(nums[j]) <= k) return true;
            }
            map.put(nums[j], j);
        }
        return false;
    }
}