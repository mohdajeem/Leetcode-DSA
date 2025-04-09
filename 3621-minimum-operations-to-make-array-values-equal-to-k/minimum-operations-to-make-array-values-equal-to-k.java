class Solution {
    public int minOperations(int[] nums, int k) {
        HashSet<Integer> set = new HashSet<>();
        for(int i =0;i<nums.length;i++){
            set.add(nums[i]);
        }
        int ans = 0;
        for(int it : set){
            // System.out.println(it+" "+k);
            if(it > k){
                ans++;
            } else if(it < k) return -1;
        }
        return ans;
    }
}