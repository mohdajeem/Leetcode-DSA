class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k%n;
        List<Integer> list = new ArrayList<>();
        for(int i = n-k;i<n;i++){
            list.add(nums[i]);
        }
        List<Integer> last = new ArrayList<>();
        for(int i = 0;i<n-k;i++){
            last.add(nums[i]);
        }
        for(int i =0;i<k;i++){
            nums[i] = list.get(i);
        }
        for(int i = k;i<n;i++){
            nums[i] = last.get(i-k);
        }
    }
}