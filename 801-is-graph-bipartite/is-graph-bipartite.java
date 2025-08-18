class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] col = new int[n];
        Arrays.fill(col, -1);
        for (int i = 0; i < n; i++) {
            if (col[i] == -1 && !dfs(i, graph, col, 0)) {
                return false;
            }
        }

        return true;
    }

    public boolean dfs(int i, int[][] graph, int[] col, int c) {
        col[i] = c;
        for (int it : graph[i]) {
            if (col[it] == -1) {
                if (!dfs(it, graph, col, Math.abs(c - 1)))
                    return false;
            } else if (col[it] == col[i]) {
                return false;
            }
        }
        return true;
    }

}