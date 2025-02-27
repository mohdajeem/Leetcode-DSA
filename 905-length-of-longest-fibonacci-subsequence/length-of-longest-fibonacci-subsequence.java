class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = arr.length;
        for(int i=0;i<arr.length;i++){
            map.put(arr[i],i);
        }
        int ans = Integer.MIN_VALUE;
        int[][] dp = new int[n][n];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        for(int i=0;i<n-1;i++){
            for(int j = i+1;j<n;j++){
                ans = Math.max(ans, f(i,j,map,arr,dp));
            }
        }
        return ans == 0 ? 0 : ans+2;
    }
    public int f(int i, int j, HashMap<Integer,Integer> map, int[] arr,int[][] dp){
        if(i==arr.length || j == arr.length) return 0;
        // ways
        if(dp[i][j] != -1) return dp[i][j];
        if(map.containsKey(arr[i]+arr[j])){
            int ind = map.get(arr[i]+arr[j]);
            return dp[i][j]=1+f(j,ind,map, arr,dp);
        }
        return dp[i][j]=0;
    }
}