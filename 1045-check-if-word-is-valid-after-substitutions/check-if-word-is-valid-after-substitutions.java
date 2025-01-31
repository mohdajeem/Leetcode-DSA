class Solution {
    public boolean isValid(String s) {
        if(s.charAt(0) != 'a') return false;
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        int i = 1;
        while(i < s.length()){
            if(s.charAt(i) == 'c'){
                StringBuilder sb = new StringBuilder();
                for(int j = 0;j<2 && !st.isEmpty();j++){
                    sb.append(st.pop());
                }
                System.out.println(sb.reverse());
                if(!sb.toString().equals("ab")){
                    return false;
                    // System.out.println("YES");
                }
                i++;
            } else{
                st.push(s.charAt(i));
                i++;
            }
        }

        return st.isEmpty() ? true : false;
    }
}