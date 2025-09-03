class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        for(int i =0;i<n;i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int tar = -nums[i];
            int j = i+1, k = n-1;
            while(j < k){
                int sum = nums[j]+nums[k];
                if(sum == tar){
                    List<Integer> list = new ArrayList<>();
                    list.addAll(Arrays.asList(nums[i], nums[j], nums[k]));
                    ans.add(new ArrayList<>(list));
                    while(j < k && nums[j] == nums[j+1]) j++;
                    while(j < k && nums[k] == nums[k-1]) k--;
                    j++;
                    k--;
                } else if(sum < tar){
                    j++;
                } else{
                    k--;
                }
            }
        }
        return ans;
    }
}