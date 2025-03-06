class Solution {
    public int maximalRectangle(char[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[][] prefixSum = new int[n][m];
        for(int i=0;i<m;i++){
            int sum =0;
            for(int j =0;j<n;j++){
                sum+=mat[j][i]-'0';
                if(mat[j][i] == '0') sum =0;
                prefixSum[j][i]=sum;
            }
        }
        for(int[] ar : prefixSum){
            System.out.println(Arrays.toString(ar));
        }
        int maxArea = 0;
        for(int[] ar : prefixSum){
            maxArea = Math.max(maxArea, largestHist(ar));
        }
        return maxArea;
    }
    public int largestHist(int[] mat){
        int n = mat.length;
        int[] ps = prevSmaller(mat, n);
        int[] ns = nextSmaller(mat,n);
        int maxArea = 0;
        for(int i =0;i<n;i++){
            int cal = (ns[i]-i)+(i-ps[i])-1;
            maxArea = Math.max(maxArea, cal*mat[i]);        }
        return maxArea;
        
    }
    public int[] nextSmaller(int[] mat, int n){
        int[] ns = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ns, n);
        st.push(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && mat[st.peek()] >= mat[i]){
                st.pop();
            }
            if(!st.isEmpty()) ns[i] = st.peek();
            st.push(i);
        }
        return ns;
    }
    public int[] prevSmaller(int[] mat,int n){
        int[] ps = new int[n];
        Stack<Integer> st = new Stack<>();
        Arrays.fill(ps,-1);
        st.push(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && mat[st.peek()]>mat[i]){
                st.pop();
            }
            if(!st.isEmpty()) ps[i] = st.peek();
            st.push(i);
        }
        return ps;
    }
}