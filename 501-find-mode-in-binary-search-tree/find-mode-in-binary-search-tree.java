/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int max = 0;
    int count = 1;
    TreeNode prev = null;
    public int[] findMode(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        dfs(root, list);
        int[] ans = new int[list.size()];
        for(int i =0;i<list.size();i++){
            ans[i] = list.get(i);
        }
        return ans;
        
    }
    public void dfs(TreeNode root, List<Integer> list){
        if(root == null) return;
        dfs(root.left, list);
        if(prev != null){
            if(prev.val == root.val){
                count++;
            } else{
                count = 1;
            }
        }
        if(count > max){
            max = count;
            list.clear();
            list.add(root.val);
        } else if(count == max) {
            list.add(root.val);
        }

        prev = root;
        dfs(root.right, list);
    }
}