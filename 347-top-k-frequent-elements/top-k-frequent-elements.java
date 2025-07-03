class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums) map.put(i, map.getOrDefault(i,0)+1);
        List<List<Integer>> freq = new ArrayList<>();
        for(int i =0;i<nums.length+1;i++){
            freq.add(new ArrayList<>());
        }
        for(int key : map.keySet()){
            int fr = map.get(key);
            freq.get(fr).add(key);
        }
        int[] ans = new int[k];
        int j =0;
        for(int i = n;i>=0;i--){
            if(freq.get(i).size() != 0){
                int l =0;
                while(k>0 && l<freq.get(i).size()){
                    ans[j++] = freq.get(i).get(l);
                    l++;
                    k--;
                }
                if(k == 0) return ans;
            }
        }
        return ans;
    }
}