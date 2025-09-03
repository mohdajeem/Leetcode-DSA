class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        Arrays.sort(nums);
        int i =0, j =0;
        while(i < n && j < n){
            while(i < n && j<n && nums[i] == nums[j]){
                j++;
            }
            int c = j-i;
            if(c > n/3){
                ans.add(nums[i]);
            }
            i=j;
        }
        return ans;
    }
}