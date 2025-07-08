class Solution {
    int cc = 0;
    public int minTime(int n, int[][] edges, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        int maxTime = 0;
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int wt = e[2];
            maxTime = Math.max(maxTime, wt);
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        int s = 0, e = maxTime;
        int ans = 0;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(isPossible(n, mid, adj, k)){
                ans = mid;
                e = mid-1;
            } else{
                s = mid+1;
            }
        }
        return ans;
    }

    public boolean isPossible(int n, int time, List<List<Pair>> adj, int k){
        boolean[] vis = new boolean[n];
        int c = 0;
        for(int i =0;i<n;i++){
            if(!vis[i]){
                c++;
                dfs(time, i, adj, vis);
            }
        }
        return c >= k;

    }
    public void dfs(int time, int src, List<List<Pair>> adj, boolean[] vis){
        vis[src] = true;
        for(Pair p : adj.get(src)){
            int node =p.node;
            int tm = p.time;
            if(!vis[node] && tm > time){
                dfs(time, node, adj, vis);
            }
        }
    }
}

class Pair{
    int node;
    int time;
    public Pair(int node, int time){
        this.node = node;
        this.time = time;
    }
}

