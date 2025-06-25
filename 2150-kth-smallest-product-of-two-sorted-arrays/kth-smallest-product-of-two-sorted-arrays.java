class Solution {
    public long kthSmallestProduct(int[] nums1, int[] nums2, long k) {
        long s = -10000000000L, e = 10000000000L;
        long ans = 0;
        while(s <= e){
            long mid = (s+e)/2;
            long count = 0;
            for(int i = 0;i<nums1.length;i++){
                count += getCount(mid, nums1[i], nums2);
            }
            if(count < k){
                s = mid+1;
            } else{
                e = mid-1;
            }
        }
        return s;
    }
    public long getCount(long prod, int x1, int[] b){
        int n2 = b.length;
        int l = 0, r = n2-1;
        while(l<=r){
            int mid = (l+r)/2;
            long product = 1L*x1*b[mid];
            if((x1 >= 0 && product <= prod) || (x1 < 0 && product > prod)){
                l = mid+1;
            } else{
                r = mid-1;
            }
        }
        if(x1 >= 0) return l;
        return n2 - l;
    }


}