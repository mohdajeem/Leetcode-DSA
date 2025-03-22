class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i =0;i<edges.length;i++){
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        boolean[] vis = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                List<Integer> nodes = new ArrayList<>();
                dfs(i, vis, adj, nodes);

                // Check if this component is a complete graph
                boolean isComplete = true;
                for (int node : nodes) {
                    if (adj.get(node).size() != nodes.size() - 1) {
                        isComplete = false;
                        break;
                    }
                }
                if (isComplete) ans++;
            }
        }
        return ans;
    }

    private void dfs(int src, boolean[] vis, List<List<Integer>> adj, List<Integer> nodes) {
        vis[src] = true;
        nodes.add(src);
        for (int neighbor : adj.get(src)) {
            if (!vis[neighbor]) {
                dfs(neighbor, vis, adj, nodes);
            }
        }
    }
}