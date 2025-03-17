class Solution {
    public boolean divideArray(int[] nums) {
        if(nums.length%2 != 0) return false;
        HashMap<Integer, Integer> map= new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        for(int key : map.keySet()){
            if(map.get(key)%2 != 0) return false;
        }
        return true;
    }
}