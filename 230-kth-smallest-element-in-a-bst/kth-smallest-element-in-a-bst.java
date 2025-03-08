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
        // PriorityQueue<Integer> pq = new PriorityQueue<>();
        // preorder(root,pq);
        // int ans = 0;
        // while(k!=0){
        //     ans = pq.remove();
        //     k--;
        // }
        // return ans;
        int[] ans = new int[1];
        int[] c = new int[1];
        recPre(root,k,c,ans);
        return ans[0];
    }

    // it is not working I don't know why
    public void recPre(TreeNode root, int k, int[] c,int[] ans){
        if(root == null) return;
        recPre(root.left, k,c,ans);
        c[0]++;
        if(c[0]==k){
            ans[0] = root.val;
            return;
        }
        recPre(root.right, k,c,ans);
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