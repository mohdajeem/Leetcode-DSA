class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        if(k >= nums.length) return nums;
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i,0)+1);
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)-> Integer.compare(b[1],a[1]));
        for(int key : map.keySet()){
            int[] arr = {key, map.get(key)};
            pq.add(arr);
        }
        int[] ans = new int[k];
        int j =0;
        for(int i =0;i<k;i++){
            ans[j++] = pq.remove()[0];
        }
        return ans;
    }
}