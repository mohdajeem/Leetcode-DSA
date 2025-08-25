class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int dir = 1, row =0, col = 0;
        int[] res = new int[n*m];
        for(int i =0;i<m*n;i++){
            res[i] = mat[row][col];
            if(dir == 1){
                if(col == m-1){
                    dir=0;
                    row++;
                } else if(row == 0){
                    dir = 0;
                    col++;
                } else{
                    row--;
                    col++;
                }
            } else{
                if(row == n-1){
                    dir = 1;
                    col++;
                } else if(col == 0){
                    dir = 1;
                    row++;
                } else{
                    row++;
                    col--;
                }
            }
        }
        return res;
    }
}