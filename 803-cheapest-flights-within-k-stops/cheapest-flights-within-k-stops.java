class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if(src == dst) return 0;

        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1], flights[i][2]));
        }
        Queue<pPair> q = new LinkedList<>();
        int[] dist = new int[n];
        Arrays.fill(dist, (int)1e9);
        q.add(new pPair(src, 0, 0));
        dist[src]=0;
        while(!q.isEmpty()){
            pPair p = q.remove();
            int pNode = p.node;
            int pDis = p.dis;
            int K = p.K;
            if(K>k) continue;
            for(Pair p1 : adj.get(pNode)){
                int node = p1.node;
                int dis = p1.dis;
                if((dis+pDis) < dist[node]){
                    dist[node] = (dis+pDis);
                    q.add(new pPair(node, dist[node], K+1));
                }
            }
        }

        return dist[dst] == (int) 1e9 ? -1 : dist[dst];
        
    }
}
class Pair{
    int node;
    int dis;
    public Pair(int node, int dis){
        this.node = node;
        this.dis = dis;
    }
}

class pPair{
    int node;
    int dis;
    int K;
    public pPair(int node, int dis, int K){
        this.node = node;
        this.dis = dis;
        this.K = K;
    }
}