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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return root;
        if(root.val == key) return helper(root);
        TreeNode dummy = root;
        while(root != null){
            if(root.left != null && root.left.val == key){
                root.left = helper(root.left);
                break;
            }else if(root.right != null && root.right.val == key){
                root.right = helper(root.right);
                break;
            } else if(root.val < key){
                root = root.right;
            } else{
                root = root.left;
            }
        }
        return dummy;
    }
    public TreeNode helper(TreeNode root){
        if(root.left == null){
            return root.right;
        }
        if(root.right == null) return root.left;
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        TreeNode rightMost = findRightMost(root.left);
        rightMost.right = rightNode;
        return leftNode;
    }
    public TreeNode findRightMost(TreeNode root){
        while(root.right != null){
            root = root.right;
        }
        return root;
    }
}