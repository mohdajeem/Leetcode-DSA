class Solution {
    public List<String> letterCombinations(String digits) {
        List<List<Character>> adj = new ArrayList<>();
        adj.add(new ArrayList<>(Arrays.asList('#')));
        adj.add(new ArrayList<>(Arrays.asList('#')));
        adj.add(new ArrayList<>(Arrays.asList('a','b','c')));
        adj.add(new ArrayList<>(Arrays.asList('d','e','f')));
        adj.add(new ArrayList<>(Arrays.asList('g','h','i')));
        adj.add(new ArrayList<>(Arrays.asList('j','k','l')));
        adj.add(new ArrayList<>(Arrays.asList('m','n','o')));
        adj.add(new ArrayList<>(Arrays.asList('p','q','r','s')));
        adj.add(new ArrayList<>(Arrays.asList('t','u','v')));
        adj.add(new ArrayList<>(Arrays.asList('w','x','y','z')));
        // HashMap<Integer, List<Character>> map = new HashMap<>();
        // map.put(0,new ArrayList<>());
        // List<Character> list1 = new 
        List<String> ans = new ArrayList<>();
        if(digits.equals("")){
            return ans;
        }
        rec(0,digits,"",ans,adj);
        return ans;

    }
    public void rec(int ind, String dig, String st, List<String> ans, List<List<Character>> adj){
        if(ind == dig.length()){
            ans.add(st);
            return;
        }
        for(char ch : adj.get(dig.charAt(ind)-'0')){
            rec(ind+1,dig, st+String.valueOf(ch), ans, adj);
        }
    }
}