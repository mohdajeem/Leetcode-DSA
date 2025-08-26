/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return lca(p,q,root);
    }
    public TreeNode lca(TreeNode p, TreeNode q, TreeNode root){
        if(root == null) return null;

        if(root == p || root == q) return root;
        TreeNode left = lca(p,q, root.left);
        TreeNode right = lca(p,q, root.right);
        if(left == null) return right;
        else if(right == null) return left;
        return root;
    }
}