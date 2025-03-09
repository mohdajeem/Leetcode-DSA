class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n=nums.length;
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        if(n<4) return ans;
        for(int i=0;i<n;i++){
            if(i>0 && nums[i] == nums[i-1]) continue;
            for(int j =i+1;j<n;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                // int tar = -;
                int left = j+1, right = n-1;
                while(left < right){
                    long sum = (long) nums[left]+nums[right]+(nums[i]+nums[j]);
                    if(sum == target){
                        List<Integer> list = Arrays.asList(nums[i],nums[j],nums[left],nums[right]);
                        list.sort(null);
                        ans.add(new ArrayList<>(list));
                        while(left < right && nums[left] == nums[left+1]) left++;
                        while(left < right && nums[right] == nums[right-1]) right--;
                        left++;
                        right--;
                    } else if(sum > target){
                        right--;
                    } else{
                        left++;
                    }
                }
            }
        }
        return ans;
    }
}