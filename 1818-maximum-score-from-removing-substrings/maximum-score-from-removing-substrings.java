class Solution {
    public int maximumGain(String s, int x, int y) {
        int c = 0;
        Stack<Character> st = new Stack<>();
        char[] chr = s.toCharArray();
        // int flag;
        // if(x>y) flag = 1;
        // else flag = 0;
        if(x>y){
            for(int i = 0; i< chr.length;i++){
                if(!st.isEmpty() && st.peek() == 'a' && chr[i] == 'b'){
                    st.pop();
                    c+=x;
                }
                else st.push(chr[i]);
            }
            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty()){
                sb.append(st.pop());
            }
            char[] ch = sb.reverse().toString().toCharArray();
            for(int i = 0;i<ch.length; i++){
                if(!st.isEmpty() && st.peek() == 'b' && ch[i] == 'a'){
                    st.pop();
                    c+=y;
                }
                else st.push(ch[i]);
            }
        } else{ 
            for(int i = 0; i< chr.length;i++){
                if(!st.isEmpty() && st.peek() == 'b' && chr[i] == 'a'){
                    st.pop();
                    c+=y;
                }
                else st.push(chr[i]);
            }
            StringBuilder sb = new StringBuilder();
            while(!st.isEmpty()){
                sb.append(st.pop());
            }
            char[] ch = sb.reverse().toString().toCharArray();
            for(int i = 0;i<ch.length; i++){
                if(!st.isEmpty() && st.peek() == 'a' && ch[i] == 'b'){
                    st.pop();
                    c+=x;
                }
                else st.push(ch[i]);
            }

        }
        return c;
    }
    
}