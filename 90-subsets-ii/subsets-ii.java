class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        genSub(0, nums.length, nums, new ArrayList<>(), ans, set);
        return ans;
    }
    public void genSub(int ind, int n, int[] nums, List<Integer> list, List<List<Integer>> ans, Set<List<Integer>> set){
        if(ind == n){
            List<Integer> l1 = new ArrayList<>(list);
            Collections.sort(l1);
            if(set.contains(l1)) return;
            ans.add(new ArrayList<>(list));
            set.add(l1);
            return;
        }
        list.add(nums[ind]);
        genSub(ind+1, n, nums, list, ans,set);
        list.remove(list.size()-1);
        genSub(ind+1, n, nums, list, ans,set);
    }
}