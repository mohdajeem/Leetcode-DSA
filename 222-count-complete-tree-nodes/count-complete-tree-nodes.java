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
    public int countNodes(TreeNode root) {
        HashSet<TreeNode> vis = new HashSet<>();
        // Queue<Pair> q = new Queue<>();
        // q.add(new Pair(root,1));
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        int c = 1;
        q.add(root);
        while(!q.isEmpty()){
            // Pair p = new Pair
            TreeNode node = q.remove();
            if(node.left != null){
                c++;
                q.add(node.left);
            }
            if(node.right != null){
                c++;
                q.add(node.right);
            }
        }
        return c;





    }
}

class Pair{
    TreeNode node;
    int n;
    public Pair(TreeNode node, int n){
        this.node = node;
        this.n =n;
    }
}