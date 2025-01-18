class Solution {
    public int findCircleNum(int[][] isConnected) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<isConnected.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<isConnected.length;i++){
            for(int j = 0;j<isConnected.length;j++){
                if(isConnected[i][j] == 1){
                    adj.get(i).add(j);
                }
            }
        }
        boolean[] vis = new boolean[adj.size()];
        int c = 0;
        for(int i = 0;i<adj.size();i++){
            if(!vis[i]){
                c++;
                dfs(adj, vis, i);
            }
        }
        return c;
    }
    public void dfs(ArrayList<ArrayList<Integer>> adj, boolean[] vis, int s){
        vis[s] = true;
        for(int it : adj.get(s)){
            if(!vis[it]){
                dfs(adj, vis, it);
            }
        }
    }

}