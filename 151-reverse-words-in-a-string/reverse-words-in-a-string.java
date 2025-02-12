class Solution {
    public String reverseWords(String s) {
        
        String[] st = s.trim().split(" ");
        Stack<String> stck = new Stack<>();
        for(int i = 0;i<st.length;i++){
            if(st[i] != "") stck.push(st[i]);
        }
        StringBuilder sb = new StringBuilder();
        while(!stck.isEmpty()){
            sb.append(stck.pop()).append(" ");
        }
        return sb.toString().trim();
    }
}