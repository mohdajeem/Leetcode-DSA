class Solution {
    public int myAtoi(String s) {
        String st = s.trim();
        int i =0, len = st.length();
        if(len == 0) return 0;
        boolean isNeg = false;
        if (st.charAt(i) == '+' || st.charAt(i) == '-') {
            if (st.charAt(i) == '-') isNeg = true;
            i++;
        }
        while(i<len && st.charAt(i)=='0'){
            i++;
        }
        String res = rec(i,st);
        if(res.length() == 0) return 0;
        long num = 0;
        try{
            num = Long.parseLong(res);
        } catch(NumberFormatException e){
            return isNeg ? Integer.MIN_VALUE : Integer.MAX_VALUE;
        }
        if(isNeg) num = -num;

        if(num < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(num > Integer.MAX_VALUE)  return Integer.MAX_VALUE;

        return (int) num;
    }
    public String rec(int i, String s){
        if(i == s.length()) return "";

        if(Character.isDigit(s.charAt(i))){
            return s.charAt(i)+""+rec(i+1, s);
        }
        return "";
    }
}