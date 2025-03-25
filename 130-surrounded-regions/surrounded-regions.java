class Solution {
    public void solve(char[][] board) {
        // vis[][] array - boolean
        // array - track O's ka surrounding
        // make a function of bfs 
        int n = board.length, m = board[0].length;
        boolean[][] vis = new boolean[n][m];
        int[][] arr=new int[n][m];
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if((i==0||i==n-1)){
                    if(!vis[i][j] && board[i][j] == 'O'){
                        bfs(i,j,n,m,vis,arr,board);
                    }
                } else{
                    if(j==0 || j == m-1){
                        if(!vis[i][j] && board[i][j]=='O'){
                            bfs(i,j,n,m,vis,arr,board);
                        }
                    }
                }
                
            }
        }
        for(int[] ar:arr){
            System.out.println(Arrays.toString(ar));
        }
        // now I have arr and board
        for(int i=0;i<n;i++){
            for(int j =0;j<m;j++){
                if(board[i][j] == 'O' && arr[i][j] != 1){
                    board[i][j]='X';
                }
            }
        }
    }

    public void bfs(int i, int j, int n,int m, boolean[][] vis, int[][] arr, char[][] board){
        Queue<Pair> q = new LinkedList<>();
        vis[i][j] = true;
        arr[i][j] = 1;
        q.add(new Pair(i,j));
        while(!q.isEmpty()){
            Pair p = q.remove();
            int row = p.row;
            int col = p.col;
            int[] drow = {0,-1,0,1};
            int[] dcol = {1,0,-1,0};
            for(int z =0;z<4;z++){
                int nrow = row+drow[z];
                int ncol = col+dcol[z];
                if(nrow >=0 && nrow < n && ncol>=0 && ncol < m && !vis[nrow][ncol] && board[nrow][ncol] == 'O'){
                    vis[nrow][ncol] = true;
                    arr[nrow][ncol] = 1;
                    q.add(new Pair(nrow,ncol));
                }
            }
        }
    }
}

class Pair{
    int row;
    int col;
    public Pair(int row, int col){
        this.row=row;
        this.col=col;
    }
}