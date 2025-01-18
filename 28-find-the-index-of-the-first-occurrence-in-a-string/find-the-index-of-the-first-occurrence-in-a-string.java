class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() < needle.length()) return -1;
        int l = 0, r = 0;
        int ans = -1;
        boolean flag = false;
        while(l < haystack.length() && r < needle.length()){
            if(needle.charAt(r) == haystack.charAt(l)){
                int a = l;
                while(l<haystack.length() && r < needle.length() && needle.charAt(r) == haystack.charAt(l)){
                    r++;
                    l++;
                }
                if(r == needle.length()) ans = a;
            } else{
                ans = -1;
                l = l-r+1;
                r = 0;
            }
        }
        return ans;
    }
}