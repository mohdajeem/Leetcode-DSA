class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> left = new ArrayList<>();
        List<Integer> equal = new ArrayList<>();
        List<Integer> right = new ArrayList<>();
        int[] ans = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            if(nums[i] > pivot){
                right.add(nums[i]);
            }else if(nums[i] == pivot){
                equal.add(nums[i]);
            }else{
                left.add(nums[i]);
            }
        }
        // List<List<Integer>> ans = new ArrayList<>();
        int j = 0;
        for(int i=0;i<left.size();i++){
            ans[j++]=left.get(i);
        }
        for(int i=0;i<equal.size();i++){
            ans[j++]=equal.get(i);
        }
        for(int i = 0;i<right.size();i++){
            ans[j++]=right.get(i);
        }
        return ans;
    }
}