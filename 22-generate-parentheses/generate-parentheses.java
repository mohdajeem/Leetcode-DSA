class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        f(0,0,n,"",ans);
        return ans;
    }
    public void f(int open, int close, int n, String s, List<String> ans){
        if(open == n && close == n){
            System.out.println(s);
            ans.add(s);
            return;
        }
        if(open < n){
            f(open+1, close, n, s+"(", ans);
        }

        if(close < open){
            f(open, close+1, n, s+")",ans);
        }

    }

    
}