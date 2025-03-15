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
    public TreeNode bstFromPreorder(int[] preorder) {
        return makeBST(preorder, Integer.MAX_VALUE, new int[]{0});
    }
    public TreeNode makeBST(int[] preorder,int upB,int[] ptr){
        if(ptr[0] == preorder.length || preorder[ptr[0]] > upB) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[ptr[0]++]);
        root.left = makeBST(preorder, root.val, ptr);
        root.right = makeBST(preorder, upB, ptr);
        return root;
        
    }
}