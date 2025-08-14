class Solution {
    public void wiggleSort(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] ans = new int[n];
        int i = 1, j = n-1;
        // System.out.println(Arrays.toString(nums));
        while(i<n){
            ans[i] = nums[j];
            j--;
            i+=2;
        }
        i = 0;
        while(i<n){
            ans[i] = nums[j];
            j--;
            i+=2;
        }
        // System.out.println(Arrays.toString(ans));
        System.arraycopy(ans, 0, nums, 0, n);
    }
}