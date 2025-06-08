class Solution {
    HashSet<Integer> set = new HashSet<>();
    public List<Integer> lexicalOrder(int n) {
        List<Integer> ans = new ArrayList<>();
        for(int i =1;i<10;i++) rec(i, n, ans);
        return ans;
    }
    public void rec(int i, int n, List<Integer> ans){
        if(i > n) return;
        ans.add(i);
        for(int j = i*10;j<i*10+10;j++){
            rec(j,n,ans);
        }        
    }
}