class Solution {
    public int findContentChildren(int[] g, int[] s) {
        // sort g and s;
        // make 2 pointers one on g and one on s (i,j)
        // compare g[i] s[j] 
        // 1. g[i] > s[j] -> j++;
        // 2. g[i] <= s[j] -> ans++; i++,j++;
        // return asn;

        Arrays.sort(g);
        Arrays.sort(s);
        int ans = 0;
        int i=0,j=0;
        while(i<g.length && j<s.length){
            if(g[i]>s[j]) j++;
            else{
                ans++;
                i++;
                j++;
            }
        }
        return ans;
    }
}