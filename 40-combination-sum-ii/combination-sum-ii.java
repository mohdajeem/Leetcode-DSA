class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        fxn(0,target, candidates, new ArrayList<>(), ans);
        return ans;
    }

    public void fxn(int ind, int target, int[] nums, List<Integer> list, List<List<Integer>> ans){
        if(target == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=ind;i<nums.length;i++){
            if(i>ind && nums[i] == nums[i-1]) continue;
            if(nums[i] > target) break;
            list.add(nums[i]);
            fxn(i+1, target-nums[i],nums, list,ans);
            list.remove(list.size()-1);
        }
    }
}