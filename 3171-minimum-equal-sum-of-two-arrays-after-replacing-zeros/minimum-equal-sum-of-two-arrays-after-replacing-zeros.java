class Solution {
    public long minSum(int[] nums1, int[] nums2) {
        long sum1 = 0, sum2 = 0;
        int zero1 = 0, zero2 = 0;

        for(int num : nums1){
            sum1+=num;
            if(num==0) {
                zero1 += 1;
                sum1++;
            }
        }
        for(int num : nums2){
            sum2+=num;
            if(num==0) {
                zero2 += 1;
                sum2++;
            }
        }
        if((sum1 < sum2 && zero1 ==0) || (sum2 < sum1 && zero2==0)){
            return -1;
        }
        return Math.max(sum1,sum2);
        
    }
}