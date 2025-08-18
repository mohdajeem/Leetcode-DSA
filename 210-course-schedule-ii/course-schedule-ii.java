class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int n = numCourses;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        int[] indegree = new int[n];
        for (int[] ar : prerequisites) {
            int u = ar[0];
            int v = ar[1];
            adj.get(v).add(u);
            indegree[u]++;
        }
        Queue<Integer> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.remove();
            list.add(node);
            for (int it : adj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        if (list.size() != n) return new int[0];  // cycle detected
        int[] ar = new int[list.size()];
        for(int i =0;i<list.size();i++){
          ar[i] = list.get(i);
        }
        return ar;
    }
}