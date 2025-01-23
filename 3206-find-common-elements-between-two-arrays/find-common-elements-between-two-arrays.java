class Solution {
    public int[] findIntersectionValues(int[] nums1, int[] nums2) {
        HashSet<Integer> hs1 = new HashSet<>();
        HashSet<Integer> hs2 = new HashSet<>();
        int c1 =0, c2 =0;
        for(int i = 0;i<nums1.length;i++){
            hs1.add(nums1[i]);
        }
        for(int i =0;i<nums2.length;i++){
            hs2.add(nums2[i]);
        }
        // counting for one 
        for(int i =0;i<nums1.length;i++){
            if(hs2.contains(nums1[i])){
                c1++;
            }
        }
        for(int i =0;i<nums2.length;i++){
            if(hs1.contains(nums2[i])){
                c2++;
            }
        }

        return new int[]{c1,c2};
    }

}