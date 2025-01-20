class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(color == image[sr][sc]) return image;
        int element=image[sr][sc];
        dfs(image, sr, sc, color,element);
        return image;
    }
    public void dfs(int[][] image, int sr, int sc, int color, int element){
        image[sr][sc] = color;
        int[] drow = {1,0,-1,0};
        int[] dcol = {0,1,0,-1};
        for(int i = 0;i<4;i++){
            int nrow = sr+drow[i];
            int ncol = sc+dcol[i];
            if(nrow >= 0 && ncol >= 0 && nrow < image.length && ncol < image[0].length && image[nrow][ncol] == element){
                dfs(image, nrow, ncol, color, element);
            }
        }
    }
}