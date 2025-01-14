class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")) return "0";
        int n1 = num1.length();
        int n2 = num2.length();

        int[] result = new int[n1+n2];
        for(int i = n1-1;i>=0;i--){
            for(int j = n2-1;j>=0; j--){
                int mul = (num1.charAt(i)-'0')*(num2.charAt(j)-'0');
                int sum = mul + result[i+j+1];
                result[i+j+1] = sum%10;
                result[i+j]+=sum/10;
            }
        }

        // convert result array into string
        StringBuilder sb = new StringBuilder();
        for(int res : result){
            if(!(sb.length() == 0 && res == 0))
                sb.append(res);
        }
        return sb.toString();
    }
}