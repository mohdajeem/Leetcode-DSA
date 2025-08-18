class Solution {
    public int numEnclaves(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int c =0;
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(i == 0 || i == n-1 || j == 0 || j == m-1){
                    if(grid[i][j] == 1 && !vis[i][j]){
                        bfs(i,j,vis,grid,n,m);
                    }
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    c++;
                }
            }
        }
        return c;

    }
    public void bfs(int i, int j, boolean[][] vis, int[][] grid, int n, int m){
        vis[i][j] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        int[] drow = {0,-1,0,1};
        int[] dcol = {1,0,-1,0};
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            for(int k =0;k<4;k++){
                int nrow = row+drow[k];
                int ncol = col + dcol[k];
                if(isValid(nrow, ncol, n, m) && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
    public boolean isValid(int i, int j, int n, int m){
        return i >=0 && i<n && j >=0 && j<m;
    }
}

class Pair{
    int row, col;
    Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}