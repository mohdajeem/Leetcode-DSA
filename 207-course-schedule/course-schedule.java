class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] e : prerequisites){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
        }
        boolean[] vis = new boolean[n];
        boolean[] path = new boolean[n];
        for(int i =0;i<n;i++){
            if(!vis[i]){
                if(isCycle(i, vis, path, adj)) return false;
            }
        }
        return true;
    }
    public boolean isCycle(int src, boolean[] vis, boolean[] path, List<List<Integer>> adj ){
        vis[src] = true;
        path[src] = true;
        for(int it: adj.get(src)){
            if(!vis[it]){
                if(isCycle(it, vis, path, adj)) return true;
            } else if(path[it]){
                return true;
            }
        }
        path[src] = false;
        return false;
    }
}