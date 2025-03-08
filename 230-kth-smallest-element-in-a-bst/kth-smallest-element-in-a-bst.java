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
    public int kthSmallest(TreeNode root, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        preorder(root,pq);
        int ans = 0;
        while(k!=0){
            ans = pq.remove();
            k--;
        }
        return ans;
    }
    public void preorder(TreeNode root, PriorityQueue<Integer> pq){
        if(root == null){
            return;
        }
        pq.add(root.val);
        preorder(root.left, pq);
        preorder(root.right,pq);
    }
}