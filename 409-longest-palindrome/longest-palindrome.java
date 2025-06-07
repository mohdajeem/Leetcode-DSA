class Solution {
    public int longestPalindrome(String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int n = s.length();
        for(char ch : s.toCharArray()){
            freq.put(ch, freq.getOrDefault(ch,0)+1);
        }
        int cn = 1, ans = 0;
        for(char key : freq.keySet()){
            int fr = freq.get(key);
            if(fr%2 == 1){
                if(cn > 0){
                    ans+=fr;
                    cn--;
                } else{
                    ans+=fr;
                    ans--;
                }
            } else{
                ans += fr;
            }
        }
        return ans;
    }
}