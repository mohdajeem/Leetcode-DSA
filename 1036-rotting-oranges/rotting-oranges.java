class Solution {
    public int orangesRotting(int[][] grid) {
        // vis[][] boolean array
        // public pair class
        // use bfs - queue usi se iterater karunga
        // min lena hoga - which will get updated and take min each time
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        // first iterate over the array and get count of fresh oranges and if orange is rotten add that to queue
        int fresh = 0;
        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(grid[i][j]==1) fresh++;
                else if(grid[i][j]==2) q.add(new Pair(i,j,0));
            }
        }
        int min = 0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            int dis = p.dis;
            int[] drow = {0,-1,0,1};
            int[] dcol = {1,0,-1,0};
            for(int i =0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = true;
                    grid[nrow][ncol] = 2;
                    fresh--;
                    q.add(new Pair(nrow,ncol,dis+1));
                    min = Math.max(min, dis+1);
                }
            }
        }
        // int cntF = 0;
        // for(int i =0;i<n;i++){
        //     for(int j =0;j<m;j++){
        //         if(grid[i][j] == 1){
        //             c++;
        //         }
        //     }
        // }
        return fresh == 0 ? min:-1;

    }
}
class Pair{
    int row;
    int col;
    int dis;
    public Pair(int row, int col, int dis){
        this.row = row;
        this.col = col;
        this.dis = dis;
    }
}