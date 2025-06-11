class Solution {
    public int findJudge(int n, int[][] trust) {
        int[] ind = new int[n];
        int[] out = new int[n];
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i<trust.length;i++){
            int u = trust[i][0]-1;
            int v = trust[i][1]-1;
            ind[v]++;
            out[u]++;
        }
        for(int i =0;i<n;i++){
            if(ind[i] == (n-1) && out[i] == 0) return i+1;
        }
        return -1;
    }
}
