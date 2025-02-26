class Solution {
    public int longestOnes(int[] nums, int k) {
        // queue
        // if 0 - c++, and if(c>k) remove and 0 c--
        int c = 0;
        int n = nums.length;
        Queue<Integer> q = new LinkedList<>();
        int ans =0;
        for(int i : nums){
            if(i == 0){
                ans = Math.max(ans,q.size());
                if(c == k){
                    while(!q.isEmpty() && q.peek() != 0){
                        q.remove();
                    }
                    if(!q.isEmpty()) {
                        q.remove();
                        c--;
                    }
                }
                if(c<k){
                    q.add(i);
                    c++;
                }
                
            } else{
                q.add(i);
            }
            
        }
        ans = Math.max(ans,q.size());
        return ans;
    }
}