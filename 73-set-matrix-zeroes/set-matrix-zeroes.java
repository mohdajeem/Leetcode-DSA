class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] vis = new boolean[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                // if(matrix[i][j] == 0 && !vis[i][j]){
                //     makeZero(matrix, i, j,vis);
                //     break;
                // }
                if(matrix[i][j] == 0) vis[i][j] = true;
            }
        }

        for(int i =0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(vis[i][j]){
                    makeZero(matrix, i, j, vis);
                }
            }
        }
    }
    public void makeZero(int[][] matrix, int i, int j,boolean[][] vis){

        for(int z = 0;z<matrix[0].length;z++){
            matrix[i][z] = 0;
        }
        for(int z = 0;z<matrix.length;z++){
            matrix[z][j] = 0;
        }








        // // make full row zero
        // for(int z = 0;z<matrix[0].length;z++){
        //     if(matrix[i][z]!=0 && !vis[i][z]){
        //         vis[i][z] = true;
        //         matrix[i][z] = 0;
        //     }
        // }
        // // make row with j will be zero
        // for(int z =0;z<matrix.length;z++){
        //     if(matrix[z][j] != 0 && !vis[z][i]){
        //         vis[z][j] = true;
        //         matrix[z][j] = 0;
        //     }
        // }
    }
}