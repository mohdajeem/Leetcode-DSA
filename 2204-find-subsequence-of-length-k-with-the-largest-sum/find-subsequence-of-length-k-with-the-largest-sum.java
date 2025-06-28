class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int n = nums.length;
        int[][] val = new int[n][2];
        for(int i =0;i<n;i++){
            val[i][0] = i;
            val[i][1] = nums[i];
        }

        Arrays.sort(val, (a,b) -> Integer.compare(b[1],a[1]));
        Arrays.sort(val, 0, k, (a,b) -> Integer.compare(a[0],b[0]));
        int[] ans = new int[k];
        for(int i =0;i<k;i++){
            ans[i] = val[i][1];
        }
        return ans;
    }
}