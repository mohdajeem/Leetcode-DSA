class Solution {
    public String removeOuterParentheses(String s) {
        int c=0;
        Stack<Character> st = new Stack<>();
        StringBuilder ans = new StringBuilder();
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                c++;
                if(c != 1) st.push(s.charAt(i));
            } else{
                c--;
                if(c != 0) st.push(s.charAt(i));
            }
            
        }
        while(!st.isEmpty()){
            ans.append(st.pop());
        }
        return ans.reverse().toString();
    }
}