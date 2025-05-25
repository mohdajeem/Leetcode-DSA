class Solution {
    public int longestPalindrome(String[] words) {
        HashMap<String, Integer> map = new HashMap<>();
        int ans = 0;
        for(String st : words){
            char ch1 = st.charAt(0);
            char ch2 = st.charAt(1);
            String rev = String.valueOf(ch2)+String.valueOf(ch1);
            if(map.containsKey(rev) && map.get(rev) > 0){
                ans+=4;
                map.put(rev, map.get(rev)-1);
            } else{
                map.put(st, map.getOrDefault(st, 0) + 1);

            }
        }

        // checking for same char
        for(String st : map.keySet()){
            char ch1 = st.charAt(0);
            char ch2 = st.charAt(1);
            if(ch1 == ch2 && map.get(st) > 0){
                ans+=2;
                map.put(st,map.get(st)-1);
                break;
            } 
        }
        return ans;
    }
}