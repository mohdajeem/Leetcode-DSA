class Solution {
    public String pushDominoes(String dominoes) {
        int n = dominoes.length();
        int[] indx = new int[n+2];
        char[] sym = new char[n+2];
        indx[0] = -1;
        sym[0] = 'L';
        int len = 1;
        for(int i = 0;i<n;i++){
            if(dominoes.charAt(i) != '.'){
                indx[len] = i;
                sym[len++] = dominoes.charAt(i);
            }
        }
        indx[len] = n;
        sym[len++]='R';

        char[] ans = dominoes.toCharArray();
        for(int idx = 0;idx < len-1; idx++){
            int i = indx[idx];
            int j = indx[idx+1];
            char x = sym[idx];
            char z = sym[idx+1];
            char write;
            if(x == z){
                for(int k = i+1;k<j;k++){
                    ans[k]=x;
                }
            } else if(x>z){
                for(int k = i+1;k<j;k++){
                    ans[k] = (k-i) == (j-k) ? '.' : k-i < j-k ? 'R' : 'L';
                }
            }
        }
        return String.valueOf(ans);
    }
}