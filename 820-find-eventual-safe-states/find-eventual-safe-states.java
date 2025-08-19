class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] outDegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());

        for(int i =0;i<n;i++){
            for(int j =0;j<graph[i].length;j++){
                adj.get(graph[i][j]).add(i);
            }
        }

        for(int i=0;i<n;i++) outDegree[i] = graph[i].length;
        Queue<Integer> q = new LinkedList<>();
        for(int i =0;i<n;i++){
            if(outDegree[i] == 0) q.add(i);
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            int node = q.remove();
            ans.add(node);
            for(int it : adj.get(node)){
                outDegree[it]--;
                if(outDegree[it]==0){
                    q.add(it);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}