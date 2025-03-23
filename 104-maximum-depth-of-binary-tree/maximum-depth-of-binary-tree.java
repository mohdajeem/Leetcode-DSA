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
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return recDepth(root);
    }
    public int recDepth(TreeNode root){
        if(root == null) return 0;
        int lh = recDepth(root.left);
        int rh = recDepth(root.right);
        return Math.max(lh,rh)+1;
    }
}