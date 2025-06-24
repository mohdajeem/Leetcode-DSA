class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int maxSum = 0, sum = 0;
        for(int i = n-k;i<n;i++){
            sum+=cardPoints[i];
        }
        maxSum = sum;
        for(int i =0;i<k;i++){
            sum -= cardPoints[n-k+i];
            sum += cardPoints[i];
            maxSum = Math.max(sum, maxSum);
        }
        return maxSum;
    }
}