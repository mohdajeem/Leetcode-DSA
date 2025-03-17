class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        perm(0,nums,ans);
        return ans;
    }
    public void perm(int ind, int[] nums, List<List<Integer>> ans){
        if(ind == nums.length){
            List<Integer> list = new ArrayList<>();
            for(int i =0;i<nums.length;i++){
                list.add(nums[i]);
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i =ind;i<nums.length;i++){
            swap(ind,nums,i);
            perm(ind+1,nums,ans);
            swap(ind,nums,i);
        }
        return;
        
    }
    public void swap(int ind, int[] nums, int i){
        int temp = nums[ind];
        nums[ind] = nums[i];
        nums[i] = temp;
    }
}