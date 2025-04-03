class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses;i++){
            adj.add(new ArrayList<>());
        }
        // u->v
        for(int i =0;i<prerequisites.length;i++){
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];
            adj.get(u).add(v);
        }
        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for(int i =0;i<numCourses;i++){
            if(!vis[i]){
                if(isCyclic(i,vis,path, adj)){
                    return new int[]{};
                }
            }
        }
        // done directed graph
        int[] ans = new int[numCourses];
        boolean[] vis1=new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<numCourses;i++){
            if(!vis1[i]){
                dfs(i,vis1,st,adj);
            }
        }
        int k=0;
        while(!st.isEmpty()){
            ans[k++] = st.pop();
        }
        return ans;
        
    }
    public void dfs(int i, boolean[] vis, Stack<Integer> st, List<List<Integer>> adj){
        vis[i] = true;
        for(int it : adj.get(i)){
            if(!vis[it]){
                dfs(it, vis, st, adj);
            }
        }
        st.push(i);
    }
    public boolean isCyclic(int src, boolean[] vis, boolean[] path, List<List<Integer>> adj){
        vis[src] = true;
        path[src] = true;
        for(int it : adj.get(src)){
            if(!vis[it]){
                if(isCyclic(it, vis, path,adj)) return true;
            } else if(path[it] == true){
                return true;
            }
        }
        path[src]=false;
        return false;
    }
}