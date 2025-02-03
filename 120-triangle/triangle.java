class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        int[][] trian = new int[n][n];
        int i = 0;
        for(List<Integer> list : triangle){
            for(int j = 0;j < list.size();j++){
                trian[i][j] = list.get(j);
            }
            i++;
        }
        int[][] dp = new int[n][n];
        for(int[] arr : dp){
            Arrays.fill(arr,-1);
        }
        return min(0,0,trian,dp);
    }
    public int min(int i, int j, int[][] trian, int[][] dp){
        if(i == trian.length-1) return trian[i][j];
        if(dp[i][j] != -1) return dp[i][j];
        int down = min(i+1,j,trian,dp);
        int diag = min(i+1, j+1, trian,dp);

        return dp[i][j] = trian[i][j] + Math.min(down, diag);
    }
}