class Solution {
    public int lengthOfLongestSubstring(String s) {
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
                if(!q.isEmpty()) q.remove();
                q.add(ch);
            } else{
                q.add(ch);
                set.add(ch);
            }
        }
        ans = Math.max(ans, q.size());
        return ans;
    }
}