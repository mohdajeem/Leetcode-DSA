class Solution {
    public void rotate(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] nm = new int[n][m];
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                nm[j][n-i-1] = matrix[i][j];
            }
        }
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                matrix[i][j] = nm[i][j];
            }
        }
    }
}