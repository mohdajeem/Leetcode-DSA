class Solution {
    public void setZeroes(int[][] matrix) {
        HashSet<Integer> set = new HashSet<>();
        int n = matrix.length, m = matrix[0].length;
        boolean flag = false;
        for(int i =0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j] ==0){
                    set.add(j);
                    flag=true;
                }
            }
            if(flag){
                for(int j =0;j<m;j++){
                    matrix[i][j]=0;
                }
            }
            flag=false;
        }
        for(int val : set){
            for(int i =0;i<n;i++){
                matrix[i][val]=0;
            }
        }
    }
}