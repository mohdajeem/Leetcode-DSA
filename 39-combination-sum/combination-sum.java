class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = candidates.length;
        fxn(n-1,target, candidates, new ArrayList<>(), ans);
        return ans;
    }
    public void fxn(int ind, int target, int[] cand, List<Integer> list, List<List<Integer>> ans){
        if(ind < 0 || target<0) return;
        if(target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        if(ind == 0){
            if(target % cand[ind] == 0 && cand[ind] != 0){
                for(int i =0;i<target/cand[ind];i++){
                    list.add(cand[ind]);
                }
                ans.add(new ArrayList<>(list));
                for(int i =0;i<target/cand[ind];i++){
                    list.remove(list.size()-1);
                }
                return;
            }
            return;
        }
        fxn(ind-1, target, cand, list, ans);
        if(cand[ind] <= target){
            list.add(cand[ind]);
            fxn(ind, target-cand[ind], cand, list, ans);
            list.remove(list.size()-1);
        }

    }
}