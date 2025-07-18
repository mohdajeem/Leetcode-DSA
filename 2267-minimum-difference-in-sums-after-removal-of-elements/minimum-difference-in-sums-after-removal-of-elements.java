class Solution {
    public long minimumDifference(int[] nums) {
        int m = nums.length;
        int n = m / 3;

        Long[] leftSum = new Long[m];
        Long[] rightSum = new Long[m];

        PriorityQueue<Long> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b, a));
        PriorityQueue<Long> minHeap = new PriorityQueue<>((a, b) -> Long.compare(a, b));

        long left = 0;
        for (int i = 0; i < n; i++) {
            long val = (long) nums[i];
            maxHeap.add(val);
            left += val;
            leftSum[i] = left;
        }

        for (int i = n; i < 2 * n; i++) {
            long val = (long) nums[i];
            maxHeap.add(val);
            left += val;
            left -= maxHeap.poll();
            leftSum[i] = left;
        }

        long right = 0;
        for (int i = m - 1; i >= 2 * n; i--) {
            long val = (long) nums[i];
            minHeap.add(val);
            right += val;
            rightSum[i] = right;
        }

        for (int i = 2 * n - 1; i >= n; i--) {
            long val = (long) nums[i];
            minHeap.add(val);
            right += val;
            right -= minHeap.poll(); 
            rightSum[i] = right;
        }

        long minDiff = Long.MAX_VALUE;
        for (int i = n - 1; i < 2 * n; i++) {
            long diff = leftSum[i] - rightSum[i + 1];
            minDiff = Math.min(minDiff, diff);
        }

        return minDiff;
    }
}
