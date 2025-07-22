class Solution {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        // last se start karo
        int n = s.length();
        char last = s.charAt(n-1);
        int ans = map.get(last);
        for(int i = n-2;i>=0;i--){
            char ch = s.charAt(i);
            if(map.get(last) > map.get(ch)){
                ans -= map.get(ch);
            } else{
                ans += map.get(ch);
            }
            last = ch;
        }
        return ans;
    }
}