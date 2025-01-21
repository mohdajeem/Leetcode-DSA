class Solution {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis= new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int c1 = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j] == 1){
                    c1++;
                } else if(grid[i][j] == 2){
                    vis[i][j] = true;
                    q.add(new Pair(i,j,0));
                }
            }
        }
        int minTime = 0;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int time = p.time;
            minTime = Math.max(minTime, time);
            int[] drow = {0,-1,0,1};
            int[] dcol = {1,0,-1,0};
            for(int i =0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow>=0 && nrow<grid.length && ncol >= 0 && ncol<grid[0].length && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = true;
                    grid[nrow][ncol] = 2;
                    q.add(new Pair(nrow,ncol,time+1));
                    c1--;
                }
            }
        }

        return c1 == 0 ? minTime : -1;

    }

}

class Pair{
    int row;
    int col;
    int time;
    public Pair(int row, int col, int time){
        this.row = row;
        this.col = col;
        this.time = time;
    }
}