class Solution {
    public void solve(char[][] board) {
        int n = board.length, m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if ((i == 0 || i == n - 1) && (board[i][j] == 'O') ) {
                    bfs(i, j, vis, board, n, m);
                } else if ((j == 0 || j == m - 1) && (board[i][j] == 'O')) {
                    bfs(i, j, vis, board, n, m);
                }
            }
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(board[i][j] == 'O' && vis[i][j]==false){
                    board[i][j] = 'X';
                }
            }
        }
    }

    public void bfs(int i, int j, boolean[][] vis, char[][] board, int n, int m) {
        vis[i][j] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(i, j));
        int[] drow = { 0, -1, 0, 1 };
        int[] dcol = { 1, 0, -1, 0 };
        while (!q.isEmpty()) {
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            for (int k = 0; k < 4; k++) {
                int nrow = row + drow[k];
                int ncol = col + dcol[k];
                if (isValid(nrow, ncol, n, m) && !vis[nrow][ncol] && board[nrow][ncol] == 'O') {
                    vis[nrow][ncol] = true;
                    q.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public boolean isValid(int i, int j, int n, int m) {
        return i >= 0 && i < n && j >= 0 && j < m;
    }
}

class Pair {
    int row, col;

    Pair(int row, int col) {
        this.row = row;
        this.col = col;
    }
}