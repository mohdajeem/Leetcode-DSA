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
    public int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(1,root));
        int ans = 1;
        while(!q.isEmpty()){
            int s=q.size();
            int first = q.peek().v;
            int last = 0;
            for(int i =0;i<s;i++){
                Pair p=q.remove();
                int v = p.v;
                TreeNode node = p.node;
                last = v;
                if(node.left != null) q.add(new Pair(2*v-1,node.left));
                if(node.right != null) q.add(new Pair(2*v,node.right));
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
    }
    public int height(TreeNode root){
        if(root == null) return 0;
        int lh = height(root.left);
        int rh = height(root.right);

        return 1+Math.max(lh,rh);
    }
}
class Pair{
    int v;
    TreeNode node;
    public Pair(int v, TreeNode node){
        this.v = v;
        this.node = node;
    }
}