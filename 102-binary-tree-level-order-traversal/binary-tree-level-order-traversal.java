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
        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> li = new ArrayList<>();
            for(int j = 0;j<s;j++){
                TreeNode i = q.remove();
                li.add(i.val);
                if(i.left != null){
                    q.add(i.left);
                }
                if(i.right != null) q.add(i.right);
            }
            ans.add(new ArrayList<>(li));
        }
        return ans;
    }
}