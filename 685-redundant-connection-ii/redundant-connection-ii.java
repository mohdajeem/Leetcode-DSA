class Solution {
    public int[] findRedundantDirectedConnection(int[][] edges) {
        int n = edges.length;
        int[] par = new int[n+1];
        int[] edge1 = null;
        int[] edge2 = null;

        for(int[] e : edges){
            int u = e[0],v = e[1];
            if(par[v] != 0){
                edge1 = new int[]{par[v], v};
                edge2 = new int[]{u,v};
                e[1] = 0;
            }
            par[v] = u;
        }

        DSU ds = new DSU(n+1);
        //parent  2  3  3  4 
        for(int[] e: edges){
            int u = e[0]; // 3
            int v = e[1]; // 1
            if(v == 0) continue;
            if(ds.findUlp(u) == ds.findUlp(v)){ // 3 == 2 no
                if(edge1 != null){
                    return edge1;
                }
                return e;
            }
            ds.union(u,v); // (3,1)
        }
        return edge2;
    }
}

class DSU{
    List<Integer> parent;
    List<Integer> rank;
    DSU(int n){
        parent = new ArrayList<>();
        rank = new ArrayList<>();
        for(int i=0;i<n;i++){
            parent.add(i);
            rank.add(0);
        }
    }
    int findUlp(int node){
        if(node == parent.get(node)){
            return node;
        }
        int par = findUlp(parent.get(node));
        parent.set(node, par);
        return par;
    }
    void union(int u, int v){ // 3, 1
        int ulpU = findUlp(u); // 3
        int ulpV = findUlp(v); // 2
        if(ulpU == ulpV) return; // 3 == 2 no
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