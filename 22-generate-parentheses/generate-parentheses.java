class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new LinkedList<>();
        f(n,0,0,"",ans);
        return ans;
    }
    public void f(int n, int open, int close, String s, List<String> ans){
        if(close == n && open==n){
            ans.add(s);
            return;
        }

        if(open < n){
            f(n, open+1, close, s+"(", ans);
        }
        if(close < open){
            f(n, open, close+1, s+")", ans);
        }
    }
}