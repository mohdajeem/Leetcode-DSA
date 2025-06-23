class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums2.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums2[n-1], -1);
        int i = n-2;
        Stack<Integer> st = new Stack<>();
        st.push(nums2[n-1]);
        while(i >= 0){
            while(!st.isEmpty() && nums2[i] > st.peek()){
                st.pop();
            }
            if(st.isEmpty()){
                map.put(nums2[i], -1);
            } else{
                map.put(nums2[i],st.peek());
            }
            st.push(nums2[i]);
            i--;
        }
        int[] ans = new int[nums1.length];
        for(int j = 0;j<nums1.length;j++){
            ans[j] = map.get(nums1[j]);
        }
        return ans;

    }
}