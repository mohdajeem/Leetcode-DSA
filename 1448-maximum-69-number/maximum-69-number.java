class Solution {
    public int maximum69Number (int num) {
        String s = String.valueOf(num);
        StringBuilder sb = new StringBuilder();
        int c =0;
        for(char ch : s.toCharArray()){
            if(ch == '6' && c == 0){
                c =1;
                sb.append('9');
            } else{
                sb.append(ch);
            }
        }
        return Integer.parseInt(sb.toString());
    }
}