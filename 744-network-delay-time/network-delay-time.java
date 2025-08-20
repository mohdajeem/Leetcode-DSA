class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());

        for(int[] t : times){
            int u = t[0]-1;
            int v = t[1]-1;
            int wt = t[2];
            adj.get(u).add(new Pair(v,wt));
        }
        
        int[] dis = new int[n];
        Arrays.fill(dis, Integer.MAX_VALUE);
        Queue<Pair> q = new LinkedList<>();
        dis[k-1]=0;
        q.add(new Pair(k-1,0));
        while(!q.isEmpty()){
            Pair p = q.remove();
            int node = p.node;
            int wt = p.wt;
            for(Pair it : adj.get(node)){
                int iNode = it.node;
                int iWt = it.wt;
                if(wt+iWt < dis[iNode]){
                    dis[iNode]=wt+iWt;
                    q.add(new Pair(iNode, dis[iNode]));
                }
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (dis[i] == Integer.MAX_VALUE) return -1; // unreachable node
            ans = Math.max(ans, dis[i]); // farthest time
        }
        return ans;

    }
}
class Pair{
    int node, wt;
    Pair(int node, int wt){
        this.node = node;
        this.wt = wt;
    }
}