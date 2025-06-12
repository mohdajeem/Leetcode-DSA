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
    // int min = Integer.MAX_VALUE;
    public int getMinimumDifference(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        rec(root, ans);
        int min = Integer.MAX_VALUE;
        for(int i =0;i<ans.size()-1;i++){
            min = Math.min(min, Math.abs(ans.get(i)-ans.get(i+1)));
        }
        return min;
    }
    public void rec(TreeNode root, List<Integer> ans){
        if(root == null) return;
        if(root.left != null){
            rec(root.left, ans);
        }
        ans.add(root.val);
        if(root.right != null){
            rec(root.right, ans);
        }
    }
}