class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        // boolean[][] vis array
        // queue store row, col
        // apply bfs
        int n = image.length, m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        int original = image[sr][sc];
        image[sr][sc] = color;
        q.add(new Pair(sr,sc));
        vis[sr][sc] = true;
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            int[] drow = {0,-1,0,1};
            int[] dcol = {1,0,-1,0};
            for(int i =0;i<4;i++){
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if(nrow < n && nrow >= 0 && ncol < m && ncol >=0 && !vis[nrow][ncol] && image[nrow][ncol] == original){
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow,ncol));
                    image[nrow][ncol] = color;
                }
            }
        }
        return image;
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