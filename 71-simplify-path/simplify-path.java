class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] parts = path.split("/");

        System.out.println("End..");
        for(int i = 0;i<parts.length;i++){
            String part = parts[i];
            if(part.equals("..")){
                if(!st.isEmpty()) st.pop();
            } else if(part.equals(".") || part.equals("")){
                continue;
            } else{
                st.push(part);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
           sb.insert(0, "/"+st.pop());
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}