class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        solve(0,nums, target, new ArrayList<>(), ans);
        return ans.size();
    }
    public void solve(int ind, int[] arr, int target, ArrayList<Integer> list, ArrayList<ArrayList<Integer>> ans){
        if(ind == arr.length){
            if(target == 0){
                ans.add(new ArrayList<>(list));
            }
            return;
        }

        // add element
        list.add(arr[ind]);
        target+=arr[ind];
        // call the added function
        solve(ind+1, arr, target, list, ans);
        // without the element with negative value;
        list.remove(list.size()-1);
        list.add(-arr[ind]);
        target-=2*arr[ind];
        solve(ind+1, arr, target, list, ans);
        list.remove(list.size()-1);
    }
}