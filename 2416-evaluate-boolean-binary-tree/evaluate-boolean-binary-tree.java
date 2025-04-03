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
    public boolean evaluateTree(TreeNode root) {
        if(root == null) return true;
        return rec(root);
    }
    public boolean rec(TreeNode root){
        if(root == null) return true;
        if(isLeaf(root)){
            return root.val == 1 ? true : false;
        }
        boolean left = rec(root.left);
        boolean right = rec(root.right);

        return root.val == 3 ? (left & right) : (left | right);
    }
    public boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}