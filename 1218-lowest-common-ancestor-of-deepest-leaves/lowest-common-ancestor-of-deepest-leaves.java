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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        if(root.left == null && root.right == null) return root;
        int[] maxDepth1 = new int[1];
        int[] maxDepth2 = new int[1];
        int[] leftDec = new int[1];
        int[] rightDec = new int[1];
        recRight(root,0,maxDepth1, rightDec);
        recLeft(root,0,maxDepth2, leftDec);
        return  ances(root, leftDec, rightDec);
    }
    public TreeNode ances(TreeNode root, int[] p, int[] q){
        if(root == null || root.val == p[0] || root.val == q[0]){
            return root;
        }
        TreeNode left = ances(root.left, p,q);
        TreeNode right = ances(root.right, p, q);

        if(left != null && right != null) return root;

        return left == null ? right : left;

    }
    public void recLeft(TreeNode root, int depth, int[] maxDepth, int[] leftDec){
        if(root == null) return;
        
        // left goes 
        if(depth > maxDepth[0]){
            maxDepth[0] = depth;
            leftDec[0] = root.val;
            System.out.println(depth+ " "+ maxDepth[0] + " val : "+root.val);
            // ans.add(root.val);
        }
        recLeft(root.left, depth+1, maxDepth,leftDec);
        recLeft(root.right, depth+1, maxDepth,leftDec);
    }
    public void recRight(TreeNode root, int depth, int[] maxDepth, int[] rightDec){
        if(root == null) return;
        
        // left goes 
        if(depth > maxDepth[0]){
            maxDepth[0] = depth;
            rightDec[0] = root.val;
            System.out.println(depth+ " "+ maxDepth[0] + " val : "+root.val);
            // ans.add(root.val);
        }
        recRight(root.right, depth+1, maxDepth, rightDec);
        recRight(root.left, depth+1, maxDepth, rightDec);
    }
}