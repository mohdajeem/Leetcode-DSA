class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Queue<Character> q = new LinkedList<>();
        HashSet<Character> set = new HashSet<>();
        int ans = 0;
        for(char ch : s.toCharArray()){
            if(set.contains(ch)){
                ans = Math.max(ans, q.size());
                while(!q.isEmpty() && q.peek() != ch){
                    set.remove(q.peek());
                    q.remove();
                }
                q.remove();
                q.add(ch);
            } else{
                set.add(ch);
                q.add(ch);
            }
            ans=Math.max(ans,q.size());
        }
        return ans;
    }
}