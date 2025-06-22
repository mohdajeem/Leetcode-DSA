class Solution {
    public String[] divideString(String s, int k, char fill) {
        int n = s.length();
        int m = (int)Math.ceil((double)n/(double)k);
        String[] res = new String[m];
        System.out.println(m);
        int j =0;
        for(int i =0;i<n;i+=k){
            String str = "";
            if(i+k < n){
                str = s.substring(i,i+k);
            } else{
                str = s.substring(i,n);
                int diff = n-i;
                while((k-diff) > 0){
                    str += fill;
                    diff++;
                }
            }
            res[j++] = str;
        }
        return res;
    }
}