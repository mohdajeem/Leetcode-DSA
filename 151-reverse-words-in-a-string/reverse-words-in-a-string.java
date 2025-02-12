class Solution {
    public String reverseWords(String s) {
        
        String[] st = s.trim().split(" ");
        for(int i = 0;i<st.length;i++){
            if(st[i] != "")
            System.out.println(st[i].trim());
        }
        StringBuilder sb = new StringBuilder();
        for(int i = st.length-1;i>0;i--){
            if(st[i] != "") sb.append(st[i]+" ");
        }
        sb.append(st[0]);
        return sb.toString();
    }
}