class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] vis = new int[n][m];

        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new Pair(i,j,0));
                    vis[i][j] = 0;
                }else{
                    vis[i][j]=-1;
                }
            }
        }

        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            int dis = p.dis;
            int[] drow={0,-1,0,1};
            int[] dcol={1,0,-1,0};
            for(int i =0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol] == -1){
                    vis[nrow][ncol] = dis+1;
                    q.add(new Pair(nrow, ncol, dis+1));
                }
            }
        }

        return vis;

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