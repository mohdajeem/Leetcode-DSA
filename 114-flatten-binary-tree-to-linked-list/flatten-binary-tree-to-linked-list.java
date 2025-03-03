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
    public void flatten(TreeNode root) {
        if(root == null || (root.left == null && root.right == null)) return;

        // ListNode dummyNode = new ListNode(-1);
        List<TreeNode> ans = new ArrayList<>();
        rec(root, ans);
        TreeNode temp = root;
        for(TreeNode it : ans){
            temp.left =null;
            temp.right = it;
            temp = temp.right;
        }

    }
    public void rec(TreeNode root,List<TreeNode> ans){
        if(root == null) return;
        ans.add(root);
        rec(root.left, ans);
        rec(root.right, ans);
    }
}