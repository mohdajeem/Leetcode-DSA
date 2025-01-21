class Solution {
    public int countBattleships(char[][] board) {
        int n=board.length;
        int m=board[0].length;

        boolean[][] vis = new boolean[n][m];
        int c=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(!vis[i][j] && board[i][j] == 'X'){
                    c++;
                    bfs(board, i, j, vis);
                }
            }
        }
        return c;
    }
    public void bfs(char[][] board, int sr, int sc, boolean[][] vis){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr,sc));
        vis[sr][sc] = true;
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int[] drow = {0,-1,0,1};
            int[] dcol = {1, 0,-1,0};
            for(int i=0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow>=0 && nrow < board.length && ncol >= 0 && ncol < board[0].length && !vis[nrow][ncol] && board[nrow][ncol]=='X'){
                    vis[nrow][ncol] = true;
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