class Solution {
    public int numberOfSubstrings(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        int left=0, right = 0, ans = 0, n = s.length();
        while(right<n){
            char ch = s.charAt(right);
            map.put(ch, map.getOrDefault(ch,0)+1);
            if(map.size()==3){
                ans += (n-right);
                while(left<right){
                    char c = s.charAt(left);
                    map.put(c,map.get(c)-1);
                    left++;
                    if(map.get(c)==0) {
                        map.remove(c);
                        break;
                    }
                    if(map.size()==3){
                        ans+=(n-right);
                    }
                }
            }
            right++;
        }
        return ans;
    }
}