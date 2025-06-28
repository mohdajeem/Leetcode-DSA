class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] ans = new int[2];
        for(int i = 0;i<numbers.length;i++){
            int res = BS(numbers, target-numbers[i], i);
            if(res != -1){
                ans[0] = i+1;
                ans[1] = res+1;
                Arrays.sort(ans);
                return ans;
            }
        }
        return ans;
    }
    public int BS(int[] nums, int tar, int i){
        int n = nums.length;
        int s = 0, e = n-1;
        // int ans = -1;
        while(s <= e){
            int mid = s + (e-s)/2;
            if(nums[mid] == tar){
                if(i == mid) return mid+1;
                return mid;
            } else if(nums[mid] > tar){
                e = mid-1;
            } else{
                s = mid+1;
            }
        }
        return -1;
    }
}