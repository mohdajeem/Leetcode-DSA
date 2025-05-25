class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0;
        for(int i =0;i<words.length;i++){
            map.put(words[i], map.getOrDefault(words[i],0)+1);
        }
        // map has been built
        boolean equalOdd = false;
        for(String st : map.keySet()){
            char ch1 = st.charAt(0);
            char ch2 = st.charAt(1);
            String s = String.valueOf(ch2) + String.valueOf(ch1);
            if(map.containsKey(s) && ch1 != ch2){
                int c = Math.min(map.get(s),map.get(st));
                ans += 2*c;
            } else if(ch1 == ch2){
                // aa type string 
                int c = map.get(st);
                if(c%2 == 0){
                    ans += 2*c;
                } else {
                    equalOdd=true;
                    ans += 2*(c-1);
                }
            }
        }
        // now I want to see those values who have symmetry xx yy ll
        
        if(equalOdd) ans += 2;
        return ans;
    }
}