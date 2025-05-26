class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        rec(0,nums,new ArrayList<>(), ans);
        return ans;
    }
    public void rec(int ind, int[] nums, List<Integer> list, List<List<Integer>> ans){
        if(ind == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[ind]);
        rec(ind+1, nums, list,ans);
        list.remove(list.size()-1);
        rec(ind+1,nums,list,ans);
    }
}