class Solution {
    public int M = (int)1e9+7;
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int n = nums.length;
        int i =0, j =n-1, ans = 0;
        int[] pow = new int[n];
        Arrays.fill(pow, 1);
        for(int exp = 1;exp<n;exp++){
            pow[exp] = (pow[exp-1]<<1)%M;
        }
        while(i<=j){
            if(nums[i]+nums[j] <= target){
                ans = (ans + pow[j-i])%M;
                i++;
            }else{
                j--;
            }
        }
        return ans;
    }
}