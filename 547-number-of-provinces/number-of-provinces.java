class Solution {
    public int findCircleNum(int[][] isConnected) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<isConnected.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<isConnected.length;i++){
            for(int j =0;j<isConnected[0].length;j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                    adj.get(j).add(i);
                }
            }
        }
        // make a vis boolean arr, then iterate over n and apply dfs
        int n = adj.size();
        boolean[] vis = new boolean[n];
        int c = 0;
        for(int i =0;i<n;i++){
            if(!vis[i]){
                c++;
                dfs(i, vis,adj);
            }
        }
        return c;

    }
    public void dfs(int i, boolean[] vis, List<List<Integer>> adj){
        vis[i] = true;
        for(int it : adj.get(i)){
            if(!vis[it]) dfs(it,vis,adj);
        }
    }
}