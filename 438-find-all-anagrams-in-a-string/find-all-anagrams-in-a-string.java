class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int[] freq = new int[26];
        for(char ch : p.toCharArray()) freq[ch-'a']++;

        int n = s.length(), k = p.length(), i =0, j =0;
        while(j < n){
            char ch = s.charAt(j);
            freq[ch-'a']--;
            if(j-i+1 == k){
                if(check(freq)) ans.add(i);
                freq[s.charAt(i)-'a']++;
                i++;
            }
            j++;
        }
        return ans;
    }
    public boolean check(int[] freq){
        for(int i : freq) if(i!=0) return false;
        return true;
    }
}