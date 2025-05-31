class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        rec(0,k,n,new ArrayList<>(), ans);
        return ans;
    }
    public void rec(int last, int k, int n, List<Integer> list, List<List<Integer>> ans){
        if(k == 0 && n == 0){
            ans.add(new ArrayList<>(list));
            return;
        }
        if(k == 0 || n==0) return;

        for(int i = last+1;i<=9;i++){
            list.add(i);
            rec(i, k-1, n-i, list, ans);
            list.remove(list.size()-1);
        }
    }
}