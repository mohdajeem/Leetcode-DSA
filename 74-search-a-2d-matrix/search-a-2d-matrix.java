class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int start = 0;
        int end = n*m-1;
        while(start <= end){
            int mid = start + (end-start)/2;
            int r = mid/m;
            int c = mid%m;
            if(matrix[r][c] == target){
                return true;
            } else if(matrix[r][c] > target){
                end = mid-1;
            } else{
                start = mid+1;
            }

        }
        return false;
    }
}