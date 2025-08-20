class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<IPair>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] e : flights){
            int u = e[0];
            int v = e[1];
            int p = e[2];
            adj.get(u).add(new IPair(v,p));
        }
        int[] prc = new int[n];
        Arrays.fill(prc, Integer.MAX_VALUE);
        Queue<Pair> pq = new LinkedList<>();
        prc[src] = 0;
        pq.add(new Pair(src,0,0));
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int node = p.node;
            int price = p.price;
            int stop = p.stop;
            if(stop > k) continue;
            for(IPair it : adj.get(node)){
                int iNode = it.node;
                int iPrice = it.price;
                if(price+iPrice < prc[iNode]){
                    prc[iNode] = price+iPrice;
                    pq.add(new Pair(iNode, price+iPrice, stop+1));
                }
            }
        }
        return prc[dst] == Integer.MAX_VALUE ? -1 : prc[dst];
    }
}
class IPair{
    int node, price;
    IPair(int node, int price){
        this.node = node;
        this.price = price;
    }
}
class Pair{
    int node, price, stop;
    Pair(int node, int price, int stop){
        this.node = node;
        this.price = price;
        this.stop = stop;
    }
}