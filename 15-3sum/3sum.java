class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=0;i<n;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            int tar = -nums[i];
            int left = i+1, right = n-1;
            while(left < right){
                int sum = nums[left]+nums[right];
                if(sum == tar){
                  List<Integer> temp = Arrays.asList(nums[i],nums[left],nums[right]);
                  temp.sort(null);
                  ans.add(temp);
                  while(left < right && nums[left] == nums[left+1]) left++;
                  while(left < right && nums[right] == nums[right-1]) right--;
                  left++;
                  right--;
                } else if(sum > tar){
                    right--;
                } else{
                    left++;
                }
            }
        }
        return ans;
    }
}