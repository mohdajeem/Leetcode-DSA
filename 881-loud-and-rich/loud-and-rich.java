class Solution {
    int[] dp;
    public int[] loudAndRich(int[][] richer, int[] quiet) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = quiet.length;
        for(int i = 0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e : richer){
            int u = e[0];
            int v = e[1];
            adj.get(v).add(u);
        }
        int[] ans = new int[n];
        dp  = new int[n];
        Arrays.fill(dp,-1);
        for(int i = 0;i<n;i++){
            ans[i]=dfs(i,adj, quiet);
        }
        return ans;
    }
    public int dfs(int src, List<List<Integer>> adj, int[] quiet){
        if(adj.get(src).size() ==0) return src;
        if(dp[src] != -1) return dp[src];
        int min = quiet[src];
        int minEl = src;
        for(int it : adj.get(src)){
            int node = dfs(it, adj,quiet);
            if(quiet[node] < min){
                minEl = node;
                min = quiet[node];
            }
        }
        return dp[src] = minEl;
    }
}