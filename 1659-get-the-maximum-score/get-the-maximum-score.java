class Solution {
    int mod = 1000000007;
    public int maxSum(int[] nums1, int[] nums2) {
        long s1 = 0, s2 = 0;
        int i = 0, j = 0;
        while(i < nums1.length || j < nums2.length){
            if(i < nums1.length && (j == nums2.length || nums1[i]<nums2[j])){
                s1 +=nums1[i++];
            } else if(j < nums2.length && ( i == nums1.length || nums1[i] > nums2[j])){
                s2 += nums2[j++];
            } else{ // they both are equal
                s2 = Math.max(s1,s2) + nums1[i];
                s1 = s2;
                i++;
                j++;
            }
        }
        return (int)(Math.max(s1, s2) % mod);
    }
}