class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e : dislikes){
            int u = e[0]-1;
            int v = e[1]-1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        System.out.println(adj);
        int[] col = new int[n];
        Arrays.fill(col,-1);
        boolean[] vis = new boolean[n];
        for(int i =0;i<n;i++){
            if(col[i] == -1){
                if(!isCycle(i, adj,0, col,vis)) return false;
            }
        }
        return true;
        
    }
    public boolean isCycle(int src, List<List<Integer>> adj, int col,int[] colr, boolean[] vis){
        vis[src] = true;
        colr[src] = col;
        for(int it : adj.get(src)){
            if(!vis[it]){
                if(!isCycle(it, adj, col == 1 ? 0 : 1, colr, vis)) return false;
            } else if(col == colr[it]) return false;
        }
        return true;
    }
}