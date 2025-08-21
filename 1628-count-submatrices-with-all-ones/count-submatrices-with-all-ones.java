class Solution {
    public int numSubmat(int[][] mat) {
        int n = mat.length, m = mat[0].length;
        int[] arr = new int[m];
        int ans = 0;
        for(int[] row : mat){
            for(int i =0;i<m;i++){
                arr[i] = row[i] == 0 ? 0 : arr[i]+1;
            }
            Stack<int[]> st = new Stack<>();
            st.push(new int[]{-1,0,-1});
            for(int i=0;i<m;i++){
                int h = arr[i];
                while(h <= st.peek()[2]){
                    st.pop();
                }
                int[] top = st.peek();
                int j = top[0];
                int prev = top[1];
                int curr = prev + (i-j)*h;
                st.push(new int[]{i,curr,h});
                ans += curr;
            }
        }
        return ans;
    }
}