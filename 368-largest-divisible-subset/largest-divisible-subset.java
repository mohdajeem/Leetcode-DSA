class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,1);
        int[] hash = new int[n];
        int max=0, lastInd = -1;
        for(int i = 0;i<n;i++){
            hash[i]=i;
            for(int j = 0;j<i;j++){
                if(nums[i]%nums[j] == 0){
                    if(dp[i] < dp[j]+1){
                        dp[i] = dp[j]+1;
                        hash[i] = j;
                    }
                }
            }
            if(max < dp[i]){
                max = dp[i];
                lastInd = i;
            }
        }
        List<Integer> ans = new ArrayList<>();
        ans.add(nums[lastInd]);
        while(hash[lastInd] != lastInd){
            lastInd = hash[lastInd];
            ans.add(nums[lastInd]);
        }
        Collections.reverse(ans);
        return ans;
    }
}