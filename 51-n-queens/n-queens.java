class Solution {
    List<List<String>> ans = new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(char[] ar : board){
            Arrays.fill(ar, '.');
        }
        rec(n,0, board);
        return ans;
    }

    public void rec(int n, int row, char[][] board){
        if(row == n){
            List<String> list = new ArrayList<>();
            for(int i =0;i<n;i++){
                list.add(new String(board[i]));
            }
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<n;i++){
            if(isValid(n, row, i,board)){
                // list.add("Q");
                board[row][i]='Q';
                rec(n, row+1, board);
                // list.add(".");
                board[row][i]='.';
            }
        }

    }
    public boolean isValid(int n, int row, int col,char[][] board){

        for(int i=0;i<row;i++){
            if(board[i][col] == 'Q'){
                return false;
            }
        }
        int i = row-1, j = col-1;
        while(i>=0 && j >= 0){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }
        i = row-1;
        j = col+1;
        while(i>=0 && j < n){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j++;
        }
        return true;

    }
}