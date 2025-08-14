class Solution {
    public String largestGoodInteger(String num) {
        String ans = "";
        for(int i =0;i<=num.length()-3;i++){
            if((num.charAt(i) == num.charAt(i+1))&&(num.charAt(i+1)==num.charAt(i+2))){
                if(ans.equals("") || Integer.parseInt(ans) < Integer.parseInt(num.substring(i,i+3)))ans = num.substring(i,i+3);
            }
        }
        return ans;
    }
}