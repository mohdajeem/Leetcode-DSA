class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n-k+1];
        Deque<Integer> dq = new ArrayDeque<>();
        int l = 0, r = 0;
        while(r < k){
            if(dq.isEmpty()){
                dq.addFirst(nums[r]);
            } else{
                while(!dq.isEmpty() && dq.peekLast() < nums[r]){
                    dq.removeLast();
                }
                dq.addLast(nums[r]);
            }
            r++;
        }
        res[0] = dq.peekFirst();
        int j = 1;
        while(r < n){
            if(!dq.isEmpty() && nums[l] == dq.peekFirst()){
                dq.removeFirst();
            }
            l++;
            if(dq.isEmpty()){
                dq.addFirst(nums[r]);
            } else{
                while(!dq.isEmpty() && dq.peekLast() < nums[r]){
                    dq.removeLast();
                }
                dq.addLast(nums[r]);
            }
            r++;
            res[j++]=dq.peekFirst();
        }

        return res;
    }
}