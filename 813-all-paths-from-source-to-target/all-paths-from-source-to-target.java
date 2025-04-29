class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        path.add(0);
        dfs(0, graph, path, ans);
        return ans;
    }
    public void dfs(int src, int[][] graph, List<Integer> list, List<List<Integer>> ans){
        if(src == graph.length-1){
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int it : graph[src]){
            list.add(it);
            dfs(it, graph, list,ans);
            list.remove(list.size()-1);
        }
    }
}