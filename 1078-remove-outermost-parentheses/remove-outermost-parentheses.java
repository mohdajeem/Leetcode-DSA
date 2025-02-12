class Solution {
    public String removeOuterParentheses(String s) {
        int c=1;
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        st.push(s.charAt(0));
        for(int i = 1;i<s.length();i++){
            if(s.charAt(i) == '('){
                c++;
            } else{
                c--;
            }
            st.push(s.charAt(i));
            if(c == 0){
                StringBuilder sb = new StringBuilder();
                while(!st.isEmpty()){
                    sb.append(st.pop());
                }
                ans.append(sb.reverse().substring(1,sb.length()-1));
            }
        }
        return ans.toString();
    }
}