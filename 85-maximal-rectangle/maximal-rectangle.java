class Solution {
    public int maximalRectangle(char[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int[][] mat = new int[n][m];
        // if(n == 1) return maxRec(matrix[0]);
        for(int j =0;j<m;j++){
            mat[0][j] = (int)(matrix[0][j]-'0');
        }
        for(int i =1;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j] == '1'){
                    // mat[i][j] = (int)(matrix[i-1][j]-'0')+(int)(matrix[i][j]-'0');
                    mat[i][j] = mat[i-1][j]+1;
                }
            }
        }
        int ans = 0;
        for(int[] row : mat){
            ans = Math.max(ans, maxRec(row));
        }
        return ans;
    }
    public int maxRec(int[] heights){
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