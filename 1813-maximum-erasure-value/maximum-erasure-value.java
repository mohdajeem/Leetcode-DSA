class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int n = nums.length;
        int l =0, r=0, sum=0, ans = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while(r<n){
            sum+=nums[r];
            if(map.containsKey(nums[r])){
                int ind = map.get(nums[r]);
                for(int i = l;i<=ind;i++){
                    sum-=nums[i];
                    map.remove(nums[i]);
                    l++;
                }
            }
            map.put(nums[r], r);
            ans = Math.max(ans, sum);
            r++;
        }
        return ans;
    }
}