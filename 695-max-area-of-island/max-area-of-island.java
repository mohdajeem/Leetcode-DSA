class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] vis = new boolean[n][m];
        int maxArea = 0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    maxArea = Math.max(maxArea, bfs(grid, i, j, vis));
                }
            }
        }
        return maxArea;
        
    }
    public int bfs(int[][] grid, int sr, int sc, boolean[][] vis){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        int countArea = 1;
        vis[sr][sc]=true;
        int[] drow = {0,-1,0,1};
        int[] dcol = {1,0,-1,0};
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            
            for(int i = 0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow>=0 && nrow<grid.length && ncol>=0 && ncol<grid[0].length && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                    countArea++;
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
        return countArea;
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