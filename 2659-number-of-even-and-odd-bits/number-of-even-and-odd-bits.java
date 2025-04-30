class Solution {
    public int[] evenOddBit(int n) {
        String str = Integer.toBinaryString(n);
        // System.out.println(Integer.toBinaryString(n));
        // System.out.println(Integer.toBinaryString(v));
        int[] ans = new int[2];
        int s = str.length();
        for(int i = s-1;i>=0;i--){
            if(str.charAt(i)=='1'){
                if((s-i-1)%2==0){
                    ans[0]++;
                }else{
                    ans[1]++;
                }
            }
        }
        return ans;
    }
}