class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        DSU ds = new DSU(n+1);

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            if(ds.findUlp(u) == ds.findUlp(v)){
                return new int[]{u,v};
            }
            ds.unionByRank(u,v);
        }
        return new int[]{-1,-1};
    }
}
class DSU{
    List<Integer> parent;
    List<Integer> rank;
    DSU(int cap){
        parent = new ArrayList<>();
        rank = new ArrayList<>();
        for(int i =0;i<cap;i++){
            parent.add(i);
            rank.add(0);
        }
    }

    int findUlp(int node){
        if(parent.get(node) == node){
            return node;
        }
        int par = findUlp(parent.get(node));
        parent.set(node, par);
        return parent.get(node);
    }

    void unionByRank(int u, int v){
        int ulpU = findUlp(u);
        int ulpV = findUlp(v);
        if(ulpU == ulpV) return;
        if(rank.get(ulpU) > rank.get(ulpV)){
            parent.set(ulpV, ulpU);
        } else if(rank.get(ulpU) < rank.get(ulpV)){
            parent.set(ulpU, ulpV);
        } else{
            parent.set(ulpV, ulpU);
            rank.set(ulpU, rank.get(ulpU)+1);
        }
    }
}