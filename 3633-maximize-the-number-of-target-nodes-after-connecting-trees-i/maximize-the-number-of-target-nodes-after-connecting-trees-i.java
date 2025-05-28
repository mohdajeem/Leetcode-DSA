class Solution {
    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        int n = edges1.length+1;
        int m = edges2.length+1;
        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();
        for(int i =0;i<n;i++){
            adj1.add(new ArrayList<>());
        }
        for(int i = 0;i<m;i++) adj2.add(new ArrayList<>());
        for(int[] e : edges1){
            adj1.get(e[0]).add(e[1]);
            adj1.get(e[1]).add(e[0]);
        }
        for(int[] e : edges2){
            adj2.get(e[0]).add(e[1]);
            adj2.get(e[1]).add(e[0]);
        }
        int[] n1 = generateArr(adj1,k);
        int[] n2 = generateArr(adj2,k-1);
        System.out.println("n1: "+Arrays.toString(n1));
        System.out.println("n2: "+Arrays.toString(n2));
        int max = Integer.MIN_VALUE;
        for(int i : n2){
            max = Math.max(i,max);
        }
        for(int i =0;i<n1.length;i++){
            n1[i]=n1[i]+max;
        }
        return n1;
    }
    public int[] generateArr(List<List<Integer>> adj, int k){
        int s = adj.size();
        int[] ans = new int[s];
        for(int i =0;i<s;i++){
            ans[i]=fxn(i,adj,k);
        }
        return ans;
    }
    public int fxn(int src, List<List<Integer>> adj, int k){
        int count = 0;
        int n = adj.size();
        boolean[] vis = new boolean[n];
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(src,0));
        vis[src]=true;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int node = p.node;
            int dis = p.dis;
            if(dis <= k) count++;
            for(int it : adj.get(node)){
                if(!vis[it] && dis+1 <= k){
                    vis[it]=true;
                    q.add(new Pair(it, dis+1));
                }
            }
        }
        return count;
    }
}

class Pair{
    int node;
    int dis;
    public Pair(int node, int dis){
        this.node = node;
        this.dis = dis;
    }
}