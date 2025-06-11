class Solution {
    public int findCenter(int[][] edges) {
        int n = 0, m = edges.length;
        for(int i =0;i<m;i++){
            n = Math.max(n, Math.max(edges[i][0], edges[i][1]));
        }
        int[] edg = new int[n+1];
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            edg[v]++;
            edg[u]++;
        }
        for(int i =0;i<=n;i++){
            if(edg[i] == n-1) return i;
        }
        return -1;
    }
}