class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(i == 0 || i == n-1){
                    if(!vis[i][j] && grid[i][j] == 1){
                        bfs(i,j,n,m,vis,grid);
                    }
                } else{
                    if(j==0 || j==m-1){
                        if(!vis[i][j] && grid[i][j] == 1){
                            bfs(i,j,n,m,vis,grid);
                        }
                    }
                }
            }
        }
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    c++;
                }
            }
        }
        return c;
    }
    public void bfs(int sr,int sc,int n, int m, boolean[][] vis, int[][] grid){
        vis[sr][sc] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        grid[sr][sc] = 0;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            int[] drow = {0,-1,0,1};
            int[] dcol = {1,0,-1,0};
            for(int i =0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow >=0 && nrow<n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                    grid[nrow][ncol]=0;
                    vis[nrow][ncol]=true;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
    }
}
class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}