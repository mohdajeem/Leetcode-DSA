class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        int n = graph.length;
        for(int i = 0;i<graph.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
            }
        }
        int[] ind = new int[n];
        for(int i = 0;i<adj.size();i++){
            for(int it : adj.get(i)){
                ind[it]++;
            }
        }
        // steps for topological sort 
        // q me ind == 0 gusa dunga
        // ind -- (for each it: queue se nikalunga)
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0;i<n;i++){
            if(ind[i]==0) q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int i = q.remove();
            for(int it : adj.get(i)){
                ind[it]--;
                if(ind[it]==0) q.add(it);
            }
            ans.add(i);
        }
        Collections.sort(ans);
        return ans;
    }
}