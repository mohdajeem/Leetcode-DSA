import java.util.*;
class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        Arrays.sort(nums);
        List<Integer> ans = new ArrayList<>();
        for(int i = 0;i<nums.length-1;i++){
            if(nums[i] == nums[i+1]){
                ans.add(nums[i]);
                i++;
            }
        }
        return ans;
        // hashmap<value, count>
        // Hashtable<Integer, Integer> table = new Hashtable<>();
        // for(int i = 0;i<nums.length;i++){
        //     if(table.containsKey(nums[i])){
        //         table.put(nums[i], table.get(nums[i])+1);
        //     } else{
        //         table.put(nums[i], 1);
        //     }
        // }
        // List<Integer> ans = new ArrayList<>();
        // for(Map.Entry<Integer, Integer> val: table.entrySet()){
        //     if(val.getValue() == 2){
        //         ans.add(val.getKey());
        //     }
        // }
        // return ans;
    }
}