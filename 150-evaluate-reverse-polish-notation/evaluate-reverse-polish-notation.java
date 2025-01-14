class Solution {
    public int evalRPN(String[] tokens) {
        Stack<String> st = new Stack<>();

        for(int i = 0;i<tokens.length;i++){
            if(tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")){
                int n1 = Integer.parseInt(st.pop());
                int n2 = Integer.parseInt(st.pop());
                int tot = 0;
                if(tokens[i].equals("+")){
                    tot = n1+n2;
                } else if(tokens[i].equals("*")){
                    tot = n1*n2;
                } else if(tokens[i].equals("/")){
                    try{
                        tot = n2/n1;
                    } catch(ArithmeticException e){
                        return -1;
                    }
                } else{
                    tot = n2-n1;
                }
                st.push(String.valueOf(tot));

            } else{
                st.push(tokens[i]);
            }
        }
        
        return Integer.parseInt(st.pop());
    }
}