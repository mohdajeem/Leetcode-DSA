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
    public boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        return isRec(root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    public boolean isRec(TreeNode root, long up,long low){
        if(root==null) return true;
        if(root.val <= low || root.val >= up) return false;
        boolean left = isRec(root.left, root.val,low);
        boolean right = isRec(root.right,up,root.val);
        return left && right;

    }
}