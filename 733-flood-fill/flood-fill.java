class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]) return image;
        int element = image[sr][sc];
        bfs(image, sr, sc, color, element);
        return image;
        
    }
    public void bfs(int[][] image, int sr, int sc, int color, int element){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        image[sr][sc] = color;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int[] drow = {1,0,-1,0};
            int[] dcol = {0,-1,0,1};
            for(int i =0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow>=0 && ncol >= 0 && nrow < image.length && ncol < image[0].length && image[nrow][ncol] == element){
                    image[nrow][ncol] = color;
                    q.add(new Pair(nrow, ncol));
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