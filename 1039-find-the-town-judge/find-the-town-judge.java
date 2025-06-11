class Solution {
    public int findJudge(int n, int[][] trust) {
        // if cyclic -> return -1;
        // i will use topo sort -> by using bfs 
        // i will use reverse of directions
        // u->v -> adj.get(v).add(u);
        // then who will be the first will be the answer after topo sort
        // queue<Pair> store;
        // 
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] ind = new int[n];
        int[] out = new int[n];
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i<trust.length;i++){
            int u = trust[i][0]-1;
            int v = trust[i][1]-1;
            adj.get(v).add(u);
            ind[v]++;
            out[u]++;
        }
        for(int i =0;i<n;i++){
            if(ind[i] == (n-1) && out[i] == 0) return i+1;
        }
        return -1;
        // Queue<Integer> q = new LinkedList<>();
        // for(int i =0;i<n;i++){
        //     if(ind[i]==0) {
        //         ans.add(i+1);
        //         q.add(i);
        //     }
        // }
        // while(!q.isEmpty()){
        //     int node = q.remove();
        //     for(int it : adj.get(node)){
        //         ind[it]--;
        //         if(ind[it]==0) {
        //             q.add(it);
        //             ans.add(it+1);
        //         }
        //     }
        // }
        // for(int i =0;i<n;i++){
        //     if(ind[i] != 0) return -1;
        // }
        // int res = ans.get(0);
        // // System.out.println(res);
        // // System.out.println(adj.get(res-1).size());
        // return adj.get(res-1).size() >= (n-1) ? res : -1;
    }
}
