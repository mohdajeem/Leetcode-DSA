class Solution {
    public String largestOddNumber(String num) {
        char[] chr = num.toCharArray();
        int max = (int) -1e9;
        for(int i = num.length()-1;i>=0;i--){
            int ch = (int)(chr[i]-'0');
            if(ch % 2 != 0){
                return num.substring(0,i+1);
            }
        }
        return "";
        // return max == -1e9 ? "" : String.valueOf(max);
    }
}