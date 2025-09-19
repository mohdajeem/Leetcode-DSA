class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());
        for(int[] d : dislikes){
            int u = d[0]-1, v = d[1]-1;
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        DSU ds = new DSU(n);
        for(int u =0;u<n;u++){
            for(int v : adj.get(u)){
                if(ds.findPar(u) == ds.findPar(v)) return false;
                ds.rank(adj.get(u).get(0),v);
            }
        }
        return true;
    }
}

class DSU{
    int[] parent;
    int[] rank;
    DSU(int n){
        parent = new int[n];
        rank = new int[n];
        for(int i=0;i<n;i++){
            parent[i] = i;
        }
    }
    int findPar(int u){
        if(u == parent[u]){
            return u;
        }
        parent[u] = findPar(parent[u]);
        return parent[u];
    }
    void rank(int u, int v){
        int ulpU = findPar(u);
        int ulpV = findPar(v);
        if(ulpU == ulpV) return;
        if(rank[ulpU] > rank[ulpV]){
            parent[ulpV] = ulpU;
        } else if(rank[ulpU] < rank[ulpV]){
            parent[ulpU] = ulpV;
        } else{
            rank[ulpU]++;
            parent[ulpV] = ulpU;
        }
    }
}