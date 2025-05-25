class Solution {
    public int singleNumber(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(int it : map.keySet()){
            if(map.get(it) == 1) return it;
        }
        return -1;
    }
}