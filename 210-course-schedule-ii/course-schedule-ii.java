class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i =0;i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<prerequisites.length;i++){
            int v = prerequisites[i][0];
            int u = prerequisites[i][1];
            adj.get(u).add(v);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] path = new boolean[numCourses];
        for(int i =0;i<numCourses;i++){
            if(!vis[i]){
                if(isCycle(i,vis,path,adj)) return new int[]{};
            }
        }

        int[] ans = new int[numCourses];
        boolean[] vis1 = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();
        for(int i =0;i<numCourses;i++){
            if(!vis1[i]){
                dfs(i, vis1, adj,st);
            }
        }
        // for(int i =0;i<numCourses;i++){
        //     ans[i] = st.pop();
        // }
        int i = 0;
        while(!st.isEmpty()){
            ans[i]=st.pop();
            i++;
        }
        return ans;
    }

    public static void dfs(int i, boolean[] vis, ArrayList<ArrayList<Integer>> adj, Stack<Integer> st){
        vis[i] = true;
        for(int it : adj.get(i)){
            if(!vis[it]){
                dfs(it,vis,adj,st);
            }
        }
        st.push(i);
    }


    public boolean isCycle(int i, boolean[] vis, boolean[] path, ArrayList<ArrayList<Integer>> adj){
        // vis[i] = true, path-true, iterater over ith list check vis, and not vis at end path=false;


        vis[i] = true;
        path[i] = true;
        for(int it : adj.get(i)){
            if(!vis[it]){
                if(isCycle(it,vis,path,adj)) return true;
            } else{
                if(path[it]) return true;
            }
        }
        path[i] = false;
        return false;
    }
}