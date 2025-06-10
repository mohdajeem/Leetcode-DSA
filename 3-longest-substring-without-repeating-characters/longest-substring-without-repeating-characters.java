class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, r=0;
        int max = 0;
        int n = s.length();
        while(r<n){
            char ch = s.charAt(r);
            while(l<=r && map.containsKey(ch)){
                char chr = s.charAt(l);
                map.put(chr, map.get(chr)-1);
                l++;
                if(map.get(chr)==0) map.remove(chr);
            }
            map.put(ch,1);
            max = Math.max(map.size(), max);
            r++;
        }
        return max;
    }
}