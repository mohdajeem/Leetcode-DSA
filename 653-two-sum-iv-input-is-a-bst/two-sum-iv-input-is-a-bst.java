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
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> inord = new ArrayList<>();
        inorder(root, inord);
        int l = 0, r = inord.size()-1;
        while(l<r){
            int sum = inord.get(l)+inord.get(r);
            if(sum == k){
                return true;
            } else if(sum > k){
                r--;
            } else{
                l++;
            }
        }
        return false;
    }
    public void inorder(TreeNode root, List<Integer> ans){
        if(root == null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);
    }
}