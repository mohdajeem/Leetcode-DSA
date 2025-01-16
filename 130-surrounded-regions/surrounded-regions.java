class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        Queue<Pair> q = new LinkedList<>();
        // first row
        for(int j = 0;j<m;j++){
            if(board[0][j]=='O' && !vis[0][j]){
                    vis[0][j] = true;
                    q.add(new Pair(0,j));
                    bfs(q, vis, board);
                }
        }
        // last row
        for(int j = 0; j<m;j++){
            if(board[n-1][j]=='O' && !vis[n-1][j]){
                    vis[n-1][j] = true;
                    q.add(new Pair(n-1,j));
                    bfs(q, vis, board);
                }
        }
        // fist colum
        for(int i = 1;i<n-1;i++){
            if(board[i][0] == 'O' && !vis[i][0]){
                vis[i][0] = true;
                q.add(new Pair(i,0));
                bfs(q, vis, board);
            }
        }
        for(int i = 1;i<n-1;i++){
            if(board[i][m-1]=='O' && !vis[i][m-1]){
                    vis[i][m-1] = true;
                    q.add(new Pair(i,m-1));
                    bfs(q, vis, board);
            }
        }

        // now count the replace all O to X
        for(int i =1;i<n-1;i++){
            for(int j = 1;j<m-1;j++){
                if(!vis[i][j] && board[i][j] == 'O'){
                    board[i][j] = 'X';
                }
            }
        }
        
    }
    public void bfs(Queue<Pair> q, boolean[][] vis, char[][] board){
        while(!q.isEmpty()){
            Pair p = q.poll();
            int row = p.row;
            int col = p.col;
            int[] drow = {0,-1,0,1};
            int[] dcol = {1,0,-1,0};
            for(int i = 0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(isValid(nrow, ncol, board) && !vis[nrow][ncol] && board[nrow][ncol] == 'O'){
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }
    public boolean isValid(int row, int col, char[][] board){
        return row >= 0 && col >= 0 && row < board.length && col < board[0].length;
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