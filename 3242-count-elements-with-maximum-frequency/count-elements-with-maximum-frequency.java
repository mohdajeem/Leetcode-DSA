class Solution {
    public int maxFrequencyElements(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int maxFreq = -1;
        for(int i =0;i<nums.length;i++){
            if(!map.containsKey(nums[i])){
                maxFreq = Math.max(maxFreq,1);
                map.put(nums[i],1);
            } else{
                map.put(nums[i], map.get(nums[i])+1);
                if(map.get(nums[i])> maxFreq){
                    maxFreq = map.get(nums[i]);
                }
            }
        }
        int ans = 0;
        for(int key : map.keySet()){
            if(map.get(key) == maxFreq){
                System.out.println(key+" "+map.get(key));
                ans+= maxFreq;
            }
        }
        return ans;
    }
}