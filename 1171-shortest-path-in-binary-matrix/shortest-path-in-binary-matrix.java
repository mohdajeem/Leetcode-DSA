class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // no need to create // length of the path = no. of vis cells;
        int n = grid.length, m = grid[0].length;
        if(grid[0][0] != 0 || grid[n-1][m-1] != 0) return -1;
        int[][] dis = new int[n][m];
        for(int[] ar : dis){
            Arrays.fill(ar,Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((obj1, obj2) -> {
            return obj1.dist - obj2.dist;
        });
        pq.add(new Pair(0,0,1));
        dis[0][0] = 1;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int row = p.row;
            int col = p.col;
            int dist = p.dist;
            int[] drow = {0,-1,-1,-1,0,1,1,1};
            int[] dcol = {1,1,0,-1,-1,-1,0,1};
            for(int i =0;i<8;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(isValid(nrow,ncol, grid) && grid[nrow][ncol] ==0 && (dist+1) < dis[nrow][ncol]){
                    dis[nrow][ncol] = dist+1;
                    pq.add(new Pair(nrow, ncol, dist+1));
                }
            }
        }

        return dis[n-1][m-1] == Integer.MAX_VALUE ? -1 : dis[n-1][m-1];

        
    }
    public boolean isValid(int row, int col, int[][] grid){
        return row >= 0 && row<grid.length && col>=0 && col<grid[0].length;
    }
}

class Pair{
    int row;
    int col;
    int dist;
    public Pair(int row, int col, int dist){
        this.row = row;
        this.col = col;
        this.dist = dist;
    }
}