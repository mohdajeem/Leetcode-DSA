class Solution {
    public int maxDepth(String s) {
        Stack<Character> st = new Stack<>();
        int max = 0;
        for(char ch : s.toCharArray()){
            if(ch == '('){
                st.push(ch);
                max = Math.max(max, st.size());
            } else if(ch == ')'){
                st.pop();
            }
        }
        return max;
    }
}