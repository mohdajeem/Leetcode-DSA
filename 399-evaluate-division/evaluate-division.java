class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<Integer, String> indToStr = new HashMap<>();
        int ind =0;
        for(List<String> lst : equations){
            String s1 = lst.get(0);
            String s2 = lst.get(1);
            if(!map.containsKey(s1)){
                indToStr.put(ind, s1);
                map.put(s1, ind++);
            }
            if(!map.containsKey(s2)){
                indToStr.put(ind, s2);
                map.put(s2, ind++);
            }
        }
        int n = map.size();
        List<List<Pair>> adj = new ArrayList<>();
        for(int i =0;i<n;i++) adj.add(new ArrayList<>());

        for(int i =0;i<equations.size();i++){
            String s1 = equations.get(i).get(0);
            String s2 = equations.get(i).get(1);
            int s1Ind = map.get(s1);
            int s2Ind = map.get(s2);
            double wt = values[i];
            adj.get(s1Ind).add(new Pair(s2, wt));
            adj.get(s2Ind).add(new Pair(s1, 1/wt));
        }
        int q = queries.size();
        double[] res = new double[q];
        int k =0;
        for(List<String> st : queries){
            int s1 = map.containsKey(st.get(0)) ? map.get(st.get(0)) : -1;
            int s2 = map.containsKey(st.get(1)) ? map.get(st.get(1)) : -1;
            if(s1 == -1 || s2 == -1){
                res[k++] = -1.0;
                continue;
            }
            res[k++] = bfs(s1, s2, adj, n, map, indToStr);
        }
        return res;

    }
    public double bfs(int src, int des, List<List<Pair>> adj, int n, HashMap<String,Integer> map, HashMap<Integer, String> indToStr){
        boolean[] vis = new boolean[n];
        Queue<Pair> q = new LinkedList<>();
        vis[src] = true;
        q.add(new Pair(indToStr.get(src), 1));
        while(!q.isEmpty()){
            Pair p = q.remove();
            String node = p.node;
            double wt = p.wt;
            if(map.get(node) == des) return wt;
            for(Pair pt : adj.get(map.get(node))){
                String iNode = pt.node;
                double iWt = pt.wt;
                if(!vis[map.get(iNode)]){
                    vis[map.get(iNode)] = true;
                    q.add(new Pair(iNode, iWt*wt));
                }
            }
        }
        return -1.0;

    }
}

class Pair{
    String node;
    double wt;
    Pair(String node, double wt){
        this.node = node;
        this.wt = wt;
    }
}