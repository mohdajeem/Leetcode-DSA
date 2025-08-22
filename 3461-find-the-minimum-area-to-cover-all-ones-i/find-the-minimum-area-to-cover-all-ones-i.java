class Solution {
    public int minimumArea(int[][] grid) {
        if(grid.length == 0 || grid[0].length==0) return 0;
        int rS = Integer.MAX_VALUE;
        int rE = Integer.MIN_VALUE;
        int cS = Integer.MAX_VALUE;
        int cE = Integer.MIN_VALUE;

        for(int i =0;i<grid.length;i++){
            for(int j =0;j<grid[i].length;j++){
                if(grid[i][j] == 1){
                    rS = Math.min(rS, i);
                    rE = Math.max(rE, i);
                    cS = Math.min(cS, j);
                    cE = Math.max(cE, j);
                }
            }
        }
        if(rS == Integer.MAX_VALUE) return 0;

        return (rE - rS + 1)*(cE-cS+1);

    }
}