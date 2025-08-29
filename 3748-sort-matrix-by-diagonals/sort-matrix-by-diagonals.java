class Solution {
    public int[][] sortMatrix(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] res = new int[n][m];
        for(int row = 0;row < n;row++){
            int i = row, j = 0;
            List<Integer> list = new ArrayList<>();
            while(i<n && j < m){
                list.add(grid[i][j]);
                i++;
                j++;
            }
            Collections.sort(list, Collections.reverseOrder());
            i = row;
            j =0;
            int k =0;
            while(i<n && j < m){
                res[i][j] = list.get(k++);
                j++;
                i++;
            }
        }
        for(int col = 1;col<m;col++){
            int i =0, j = col;
            List<Integer> list = new ArrayList<>();
            while(i<n && j < m){
                list.add(grid[i][j]);
                i++;
                j++;
            }
            Collections.sort(list);
            i = 0;
            j =col;
            int k =0;
            while(i<n && j < m){
                res[i][j] = list.get(k++);
                j++;
                i++;
            }
        }
        return res;
    }
}