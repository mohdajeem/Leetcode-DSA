class Solution {
    public int makeConnected(int n, int[][] connections) {
        int len = connections.length;
        if(len < n-1) return -1;
        DSU ds = new DSU(n);
        for(int[] e : connections){
            int u = e[0];
            int v = e[1];
            ds.unionByRank(u,v);
        }
        int c = 0;
        for(int i =0;i<n;i++){
            if(ds.parent.get(i) == i) c++;
        }
        return c-1;
    }
}
class DSU{
    List<Integer> parent;
    List<Integer> rank;
    DSU(int n){
        parent = new ArrayList<>();
        rank = new ArrayList<>();
        for(int i =0;i<n;i++){
            parent.add(i);
            rank.add(1);
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
    void unionByRank(int u, int v){
        int ulpU = findUlp(u);
        int ulpV = findUlp(v);
        if(ulpU == ulpV) return;
        if(rank.get(ulpU) > rank.get(ulpV)){
            parent.set(ulpV, ulpU);
        } else if(rank.get(ulpU) < rank.get(ulpV)){
            parent.set(ulpU,ulpV);
        } else{
            parent.set(ulpV, ulpU);
            int rankU = rank.get(ulpU);
            rank.set(ulpU, rankU+1);
        }
    }
    
}