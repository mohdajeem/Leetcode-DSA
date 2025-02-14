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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode tree = q.remove();
            if(tree == null){
                ans.add(new ArrayList<>(list));
                list.clear();
                if(!q.isEmpty()){
                    q.add(null);
                }
            } else{
                list.add(tree.val);
                if(tree.left != null) q.add(tree.left);
                if(tree.right != null) q.add(tree.right);
            }
        }
        return ans;
    }
}