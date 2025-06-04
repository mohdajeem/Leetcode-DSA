class Solution {
    public String answerString(String word, int numFriends) {
        int n = word.length();
        if(n == 1 || numFriends == 1) return word;
        // find max character;
        char ch = '\0';
        for(int i =0;i<n;i++){
            if(word.charAt(i) > ch){
                ch = word.charAt(i);
            }
        }
        // System.out.println(ch);
        List<Integer> pos = allPosition(word,ch);
        String res = "";
        int longestPossible = n - (numFriends-1);
        for(int i =0;i<pos.size();i++){
            int ps = pos.get(i);
            int pssLen = Math.min(longestPossible,n-ps);
            String s = word.substring(ps, ps+pssLen);
            if(s.compareTo(res) >0){
                res =s;
            }
        }
        return res;
        
    }
    public List<Integer> allPosition(String s, char ch){
        List<Integer> ans = new ArrayList<>();
        for(int i =0;i<s.length();i++){
            if(s.charAt(i) == ch){
                ans.add(i);
            }
        }
        return ans;
    }
}