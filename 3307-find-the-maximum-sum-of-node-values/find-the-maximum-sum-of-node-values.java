class Solution {
    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        List<Integer> fayda = new ArrayList<>();
        long totSum = 0;
        for(int num : nums){
            totSum+=num;
            fayda.add((num^k) - num);
        }
        Collections.sort(fayda, Collections.reverseOrder());
        for(int i=0;i<n-1;i+=2){
            if(fayda.get(i)+fayda.get(i+1) > 0){
                totSum += (long)(fayda.get(i)+fayda.get(i+1));
            }
        }

        return totSum;
    }
}