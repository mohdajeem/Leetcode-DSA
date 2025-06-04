class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int n = g.length, m = s.length;
        int i =0,j=0, c=0;
        while(i<n && j<m){
            if(s[j] >= g[i]){
                c++;
                i++;
                j++;
            } else{
                j++;
            }
        }
        return c;
    }
}