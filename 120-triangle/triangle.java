class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size(), m = triangle.get(n-1).size();
        int[][] dp = new int[n][m];
        for(int[] ar : dp){
            Arrays.fill(ar,-1);
        }
        return f(0,0,triangle,dp);
    }
    public int f(int i, int j, List<List<Integer>> triangle,int[][] dp){
        if(i == triangle.size()-1){
            return triangle.get(i).get(j);
        }
        if(dp[i][j] != -1) return dp[i][j];
        int down = f(i+1,j,triangle,dp);
        int diag = f(i+1,j+1,triangle,dp);
        int min = triangle.get(i).get(j)+Math.min(down,diag);
        return dp[i][j]=min;
    }
}