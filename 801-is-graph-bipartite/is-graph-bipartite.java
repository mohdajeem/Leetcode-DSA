class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<n;i++){
            for(int j = 0;j<graph[i].length;j++){
                int v = graph[i][j];
                adj.get(i).add(v);
            }
        }
        int[] color = new int[n];
        Arrays.fill(color,-1);
        for(int i =0;i<n;i++){
            if(color[i] == -1){
                if(!dfs(i,0,color, adj)){
                    return false;
                }
            }
        }
        return true;

    }
    public boolean dfs(int src,int col, int[] color, List<List<Integer>> adj){
        color[src] = col;
        for(int it : adj.get(src)){
            if(color[it] == -1){
                if(!dfs(it, 1-col, color, adj)) return false;
            } else if(color[it] == color[src]){
                return false;
            }
        }
        return true;
    }
} 