class Solution {
    public static final int Max = Integer.MAX_VALUE;
    public int largestPathValue(String colors, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int n = colors.length();
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] e : edges) adj.get(e[0]).add(e[1]);
        int[][] count = new int[n][26];
        int[] vis = new int[n];
        // vis = 1, (visiting), vis = 0 not vis, vis = 2 visited
        int ans = 0;
        for(int i =0;i<n && ans != Max; i++){
            ans = Math.max(ans, dfs(i, vis, count, colors, adj));
        }
        return ans == Max ? -1 : ans;
    }
    public int dfs(int node, int[] vis,int[][] count, String colors, List<List<Integer>> adj){

        if(vis[node] == 1) return Max;
        
        if(vis[node]==2) return count[node][colors.charAt(node)-'a'];

        vis[node]=1;
        for(int it : adj.get(node)){
            int res = dfs(it, vis, count, colors, adj);
            if(res == Max) return Max;
            
            for(int c = 0;c<26;c++){
                count[node][c]=Math.max(count[node][c], count[it][c]);
            }
        }
        int col = colors.charAt(node)-'a';
        count[node][col]++;
        vis[node]=2;
        return count[node][col];


    }
}