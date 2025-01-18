class Solution {
    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis =new boolean[n][m];
        int c = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == '1') {
                    bfs(grid, vis, i,j);
                    c++;
                }
            }
        }
        return c;
    }
    public void bfs(char[][] grid, boolean[][] vis, int i, int j){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i,j));
        vis[i][j] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int[] drow = {1,0,-1,0};
            int[] dcol = {0, 1, 0, -1};
            for(int z = 0;z<4;z++){
                int nrow = row + drow[z];
                int ncol = col + dcol[z];
                if(nrow >=0 && ncol >=0 && nrow < grid.length && ncol < grid[0].length && !vis[nrow][ncol] && grid[nrow][ncol] == '1'){
                    q.add(new Pair(nrow, ncol));
                    vis[nrow][ncol] = true;
                }
            }
        }
    }
}
class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row = row;
        this.col = col;
    }
}