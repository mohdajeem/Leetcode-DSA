class Solution {
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        List<List<Integer>> ans = new ArrayList<>();
        int i = 0;
        int j = 0;
        while(i<nums1.length && j<nums2.length){
            List<Integer> list = new ArrayList<>();
            if(nums1[i][0] == nums2[j][0]){
                list.add(nums1[i][0]);
                list.add(nums1[i++][1]+nums2[j++][1]);
            }else if(nums1[i][0] < nums2[j][0]){
                list.add(nums1[i][0]);
                list.add(nums1[i++][1]);
            } else{
                list.add(nums2[j][0]);
                list.add(nums2[j++][1]);
            }
            ans.add(new ArrayList<>(list));
        }
        while(i<nums1.length){
            List<Integer> list = new ArrayList<>();
            list.add(nums1[i][0]);
            list.add(nums1[i++][1]);
            ans.add(new ArrayList<>(list));
        }
        while(j<nums2.length){
            List<Integer> list = new ArrayList<>();
            list.add(nums2[j][0]);
            list.add(nums2[j++][1]);
            ans.add(new ArrayList<>(list));
        }
        int[][] res = new int[ans.size()][2];
        for(int ik =0;ik<ans.size();ik++){
            res[ik][0] = ans.get(ik).get(0);
            res[ik][1] = ans.get(ik).get(1);
        }
        return res;
    }
}