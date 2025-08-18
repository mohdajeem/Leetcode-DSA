class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[] drow = {0,-1,0,1};
        int[] dcol = {1,0,-1,0};
        Queue<Pair> q = new LinkedList<>();
        // boolean[][] vis = new boolean[n][m];
        int cntFresh = 0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 2){
                    q.add(new Pair(i,j, 0));
                } else if(grid[i][j] == 1){
                    cntFresh++;
                }
            }
        }
        int min = 0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            int time = p.time;

            for(int i =0;i<4;i++){
                int nrow = drow[i]+row;
                int ncol = dcol[i]+col;

                if(isValid(nrow, ncol, n, m) && grid[nrow][ncol] == 1){
                    grid[nrow][ncol] = 2;
                    q.add(new Pair(nrow, ncol, time+1));
                    min = Math.max(min, time+1);
                    cntFresh--;
                }
            }
        }
        return cntFresh == 0 ? min : -1;
    }
    public boolean isValid(int row, int col, int n, int m){
        return row>=0 && row<n && col >= 0 && col<m;
    }
}
class Pair{
    int row, col, time;
    Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}