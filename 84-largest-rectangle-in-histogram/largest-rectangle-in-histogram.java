class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        int[] prevSmaller = new int[n];
        int[] nextSmaller = new int[n];
        // first solve for previous smaller
        Stack<Integer> st = new Stack<>();
        prevSmaller[0] = -1;
        st.push(0);
        for(int i =1;i<n;i++){
            while(!st.isEmpty() && heights[st.peek()] > heights[i]){
                st.pop();
            }
            if(st.isEmpty()) prevSmaller[i] = -1;
            else prevSmaller[i] = st.peek();
            st.push(i);
        }
        st.clear();
        for(int i = n-1;i>=0;i--){
            while(!st.isEmpty() && heights[st.peek()] >= heights[i]){
                st.pop();
            }
            if(st.isEmpty()) nextSmaller[i] = n;
            else nextSmaller[i] = st.peek();
            st.push(i);
        }
        int ans = 0;
        for(int i =0;i<n;i++){
            int dis = (nextSmaller[i]-i)+(i-prevSmaller[i])-1;
            ans = Math.max(heights[i] * dis, ans);
        }
        return ans;
    }
}