class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), l = 0, r =0, ans =0;
        HashSet<Character> set = new HashSet<>();
        Queue<Character> q = new LinkedList<>();
        while(r < n){
            char ch = s.charAt(r);
            if(set.contains(ch)){
                while(!q.isEmpty() && q.peek() != ch){
                    char c = q.remove();
                    set.remove(c);
                }
                q.remove(ch);
                set.remove(ch);
            }
            set.add(ch);
            q.add(ch);
            ans = Math.max(ans, q.size());
            r++;
        }
        return ans;

    }
}