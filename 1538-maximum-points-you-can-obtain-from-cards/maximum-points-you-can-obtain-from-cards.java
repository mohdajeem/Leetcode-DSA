class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int max = 0, sum = 0, n = cardPoints.length;
        for(int i =n-k;i<n;i++){
            sum += cardPoints[i];
        }
        max = Math.max(sum,max);
        for(int i = 0;i<k;i++){
            sum -= cardPoints[n-k+i];
            sum += cardPoints[i];
            max = Math.max(sum, max);
        }
        return max;
    }
}