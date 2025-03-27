class Solution {
    public int minimumIndex(List<Integer> nums) {
        // first find majority element
        // then find maxFreq of the majority element
        // not iterate to find the answer
        // prefixMajFreq > (i+1)/2 && maxFreq > (n-i-1)/2
        // than i would be our answer;
        int majorityEl = mooresLawOfMajorityElement(nums);
        int maxFreq = 0, n = nums.size();
        for(int i=0;i<n;i++){
            if(nums.get(i) == majorityEl){
                maxFreq++;
            }
        }
        int prefixMajFreq = 0;
        for(int i =0;i<n;i++){
            if(nums.get(i) == majorityEl){
                prefixMajFreq++;
                maxFreq--;
            }
            if(prefixMajFreq > (i+1)/2 && maxFreq > (n-i-1)/2){
                return i;
            }
        }
        return -1;




    }
    public int mooresLawOfMajorityElement(List<Integer> nums){
        int majorityElement = nums.get(0);
        int freq = 1;
        for(int i= 1;i<nums.size();i++){
            if(nums.get(i) != majorityElement) freq--;
            else freq++;
            if(freq == 0){
                majorityElement=nums.get(i);
                freq=1;
            }
        }
        return majorityElement;
    }
}