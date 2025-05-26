class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        f(n,n,n,"", ans);
        return ans;
    }
    public void f(int countL, int countR, int n, String s, List<String> ans){
        if(countL < 0 || countR < 0) return;
        if(countL == 0 && countR == 0){
            ans.add(s);
            return;
        }
        f(countL-1,countR,n, s+"(",ans);
        if(countL < countR){
            f(countL, countR-1, n, s+")",ans);
        }
    }
}