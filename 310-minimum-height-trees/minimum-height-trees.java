class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        int[] dgr = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++)  adj.add(new ArrayList<>());
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
            dgr[u]++;
            dgr[v]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(dgr[i] == 1) q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        if(n == 1){
            ans.add(0);
        }
        while(n>2){
            int s = q.size();
            n-=s;
            while(s != 0){
                int node = q.remove();
                s--;
                for(int it : adj.get(node)){
                    dgr[it]--;
                    if(dgr[it] == 1) q.add(it);
                }
            }
        }
        while(!q.isEmpty()){
            ans.add(q.remove());
        }
        return ans;
    }
    
}