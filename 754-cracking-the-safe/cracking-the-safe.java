class Solution {
    public String crackSafe(int n, int k) { // (2, 2)
        StringBuilder sb = new StringBuilder();
        Set<String> vis = new HashSet<>();

        StringBuilder startSb = new StringBuilder();
        for(int i =0;i<n-1;i++){
            startSb.append('0');
        } // start = 0
        String start = startSb.toString();
        dfs(start, n, k, sb, vis);
        sb.append(start);
        return sb.toString();
    }
    public void dfs(String start, int n, int k, StringBuilder sb, Set<String> vis){
        for(int i =0;i<k;i++){
            String edge = start+(char)('0'+i);
            if(!vis.contains(edge)){
                vis.add(edge);
                dfs(edge.substring(1), n, k, sb, vis);
                sb.append((char)('0'+i));
            }
        }
    }
}