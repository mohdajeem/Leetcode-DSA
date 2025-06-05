class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        Map<Character, List<Character>> adj = new HashMap<>();
        int n = s1.length();
        for(int i =0;i<n;i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            adj.computeIfAbsent(ch1, k -> new ArrayList<>()).add(ch2);
            adj.computeIfAbsent(ch2, k -> new ArrayList<>()).add(ch1);
        }
        Map<Character, Character> memo = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for(int i =0;i<baseStr.length();i++){
            char start = baseStr.charAt(i);
            if(memo.containsKey(start)){
                sb.append(memo.get(start));
            } else{
                char ch = solve(start,adj,baseStr);
                memo.put(start, ch);
                sb.append(ch);
            }
        }
        return sb.toString();

    }
    public char solve(char start, Map<Character, List<Character>> adj, String baseStr){
        boolean[] vis = new boolean[26];
        char[] minChr = new char[]{start};
        dfs(start, minChr, adj, vis);
        return minChr[0];
    }
    public static void dfs(char chr, char[] minChr, Map<Character, List<Character>> adj, boolean[] vis){
        vis[chr-'a']=true;
        if(chr < minChr[0]){
            minChr[0] = chr;
        }
        if(!adj.containsKey(chr)) return;
        for(char ch : adj.get(chr)){
            if(!vis[ch-'a']){
                dfs(ch,minChr,adj,vis);
            }
        }
    }

}