class Solution {
    public int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        final int MOD = 1_000_000_007;
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<Pair>());
        }
        for(int i =0;i<roads.length;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1],roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0],roads[i][2]));
        }
        long[] dist = new long[n];
        Arrays.fill(dist,Long.MAX_VALUE);
        int[] ways = new int[n];
        PriorityQueue<Pair> pq = new PriorityQueue<>((obj1, obj2) -> Long.compare(obj1.dis, obj2.dis));
        pq.add(new Pair(0,0));
        dist[0] = 0;
        ways[0] =1;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.node;
            long dis = p.dis;
            for(Pair it : adj.get(node)){
                int iNode = it.node;
                long idis = it.dis;
                if(dist[iNode] > (idis+dis)){
                    ways[iNode] = ways[node];
                    dist[iNode] = (idis+dis);
                    pq.add(new Pair(iNode, dist[iNode]));
                } else if(dist[iNode] == (idis + dis)){
                    ways[iNode] = (ways[iNode] +  ways[node])%MOD;
                    // pq.add(new Pair(iNode, dist[iNode]));
                } else{
                    continue;
                }

            }
        }
        return ways[n-1]%MOD;
    }
}

class Pair{
    int node;
    long dis;
    public Pair(int node, long dis){
        this.node = node;
        this.dis = dis;
    }
}