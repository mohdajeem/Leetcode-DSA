class Solution {
    public int maximumWealth(int[][] accounts) {
        int p = accounts.length;
        int w = accounts[0].length;
        int maxWealth = 0;
        for(int i =0;i<p;i++){
            int sum = 0;
            for(int j =0;j<w;j++){
                sum+=accounts[i][j];
            }
            maxWealth = Math.max(maxWealth,sum);
        }
        return maxWealth;

    }
}