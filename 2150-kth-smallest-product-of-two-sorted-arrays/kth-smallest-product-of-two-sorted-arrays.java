class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long low = -10000000000L, high = 10000000000L;
        int n = nums1.length;
        while(low <= high){
            long mid = (low+high)/2;
            long count = 0;
            for(int i = 0;i<n;i++){
                count += fxn(nums1[i], mid,nums2);
            }
            if(count < k){
                low = mid+1;
            } else{
                high = mid -1;
            }
        }
        return low;
    }
    public long fxn(int x, long prod, int[] nums2){
        int n2 = nums2.length;
        int l = 0, h = n2-1;
        while(l<=h){
            int mid = (l+h)/2;
            long pr = 1L*x*nums2[mid];
            if((x >= 0 && pr <= prod) || (x<0 && pr > prod) ){
                l = mid+1;
            } else{
                h = mid-1;
            }
        }
        if(x >= 0) return l;
        return n2 - l;

    }
}