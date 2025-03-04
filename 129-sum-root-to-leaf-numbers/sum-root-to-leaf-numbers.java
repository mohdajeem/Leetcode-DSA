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
    public int sumNumbers(TreeNode root) {
        if(root == null) return 0;
        int[] totSum = new int[1];
        rec(root, 0,totSum);
        return totSum[0];
    }
    public void rec(TreeNode root, int sum, int[] totSum){
        if(root == null) return ;
        sum = sum*10 + root.val;
        if(isLeaf(root)){
            totSum[0] += sum;
            return;
        }
        rec(root.left, sum, totSum);
        rec(root.right, sum, totSum);


    }
    public boolean isLeaf(TreeNode node){
        return node.left == null && node.right == null;
    }
}