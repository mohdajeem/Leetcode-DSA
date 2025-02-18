class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        // return -1 :- (0,0) != 0 || (n-1,n-1) != 0 -> return -1;
        // all 8 directions me jaana and check (0 and mindis);
        // src =0,0 se start; 
        // agar 0, dis+1, min 
        int n = grid.length;
        int m = grid[0].length;
        if(grid[0][0]!=0 || grid[n-1][m-1]!=0) return -1;
        int[][] dis = new int[n][m];
        for(int[] ar : dis){
            Arrays.fill(ar, (int) 1e9);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((obj1,obj2) -> {
            return obj1.dist - obj2.dist;
        });
        pq.add(new Pair(0,0,1));
        dis[0][0]=1;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int row = p.row;
            int col = p.col;
            int dist = p.dist;
            int[] drow = {-1,-1,-1,0,1,1,1,0};
            int[] dcol = {-1,0,1,1,1,0,-1,-1};
            for(int i = 0;i<8;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow >=0 && ncol >=0 && nrow <n && ncol <m && grid[nrow][ncol]==0 && dis[nrow][ncol]>dist+1){
                    pq.add(new Pair(nrow,ncol,dist+1));
                    dis[nrow][ncol] = dist+1;
                }
            }
        }
    return (dis[n-1][m-1] == (int)1e9) ? -1 : (dis[n-1][m-1]);
    }
}
class Pair{
    int row;
    int col;
    int dist;
    public Pair(int row, int col, int dist){
        this.row=row;
        this.col=col;
        this.dist=dist;
    }

}