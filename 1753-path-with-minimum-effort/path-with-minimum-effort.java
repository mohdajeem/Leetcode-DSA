class Solution {
    public int minimumEffortPath(int[][] heights) {
        // dis[][] array create karo 
        // then ek priorityQueue with dist 
        // then apply bfs and return last one 
        int n = heights.length, m = heights[0].length;
        int[][] dis = new int[n][m];
        for(int[] ar : dis){
            Arrays.fill(ar,Integer.MAX_VALUE);
        }
        PriorityQueue<Pair> pq = new PriorityQueue<>((obj1, obj2) -> {
            return obj1.dist - obj2.dist;
        });
        pq.add(new Pair(0,0,0));
        dis[0][0]=0;
        while(!pq.isEmpty()){
            Pair p = pq.remove();
            int row = p.row;
            int col = p.col;
            int dist = p.dist;
            int[] drow = {0,-1,0,1};
            int[] dcol = {1,0,-1,0};
            for(int i =0;i<4;i++){
                int nrow = row+drow[i];
                int ncol = col+dcol[i];
                if(nrow >=0 && nrow<n && ncol >= 0 && ncol < m){
                    int abs = Math.abs(heights[row][col]-heights[nrow][ncol]);
                    abs = Math.max(abs, dist);
                    if(abs < dis[nrow][ncol]){
                        dis[nrow][ncol] = abs;
                        pq.add(new Pair(nrow, ncol, abs));
                    }
                }
            }
        }

        return dis[n-1][m-1];
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