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
    public int maxPathSum(TreeNode root) {
        if(root==null) return 0;
        int[] sum = new int[1];
        sum[0]=Integer.MIN_VALUE;
        rec(root,sum);
        return sum[0];
    }
    public int rec(TreeNode root, int[] sum){
        if(root == null) return 0;
        int lh = rec(root.left, sum);
        if(lh<0) lh= 0;
        int rh = rec(root.right, sum);
        if(rh<0) rh= 0;
        sum[0] = Math.max(sum[0], lh+rh+root.val);
        return root.val+Math.max(lh,rh);
    }
}