class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums2.length;
        for(int i =0;i<n;i++){
            map.put(nums2[i], i);
        }
        int[] arr = new int[n];
        Arrays.fill(arr, -1);
        Stack<Integer> st = new Stack<>();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && st.peek() < nums2[i]){
                st.pop();
            }
            if(!st.isEmpty()) arr[i] = st.peek();
            st.push(nums2[i]);
        }
        int m = nums1.length;
        int[] ans = new int[m];
        for(int i =0;i<m;i++){
            int ind = map.get(nums1[i]);
            ans[i] = arr[ind];
        }
        return ans;
    }
}