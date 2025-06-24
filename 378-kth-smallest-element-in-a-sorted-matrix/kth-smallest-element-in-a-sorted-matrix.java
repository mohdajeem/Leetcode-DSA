class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length, m = matrix[0].length;
        int s = matrix[0][0], e = matrix[n-1][m-1];
        int ans = 0;
        while(s <= e){
            int mid = s + (e-s)/2;
            int row = mid/n;
            int col = mid%m;
            if(countLessThanX(mid,matrix) >= k){
                ans = mid;
                e = mid-1;
            } else{
                s = mid+1;
            }
        }
        return ans;
    }
    public int countLessThanX(int x, int[][] matrix){
        int n = matrix.length, m = matrix[0].length;
        int i =0, j = m-1;
        int count = 0;
        while(i<n && j >=0){
            if(matrix[i][j] <= x){
                count+=(j+1);
                i++;
            } else{
                j--;
            }
        }
        return count;
    }
}