class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = 0, j = 0;
        if(n == 0){
            return;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while(i<m && j<n){
            if(nums1[i] <= nums2[j]){
                list.add(nums1[i++]);
            }
            else{
                list.add(nums2[j++]);
            }
        }
        while(i<m){
            list.add(nums1[i++]);
        }
        while(j<n){
            list.add(nums2[j++]);
        }

        for(int i1 =0;i1<list.size();i1++){
            nums1[i1] = list.get(i1);
        }
    }
}