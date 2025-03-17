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
    public List<Integer> inorderTraversal(TreeNode root) {
        // i will do iterative order traversal
        Stack<TreeNode> st = new Stack<>();
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        st.push(root);
        // jb tk root.left != null -> push(root)
        // when we get 
        while(true){
            while(root.left != null){
                st.push(root.left);
                root = root.left;
            }
            TreeNode node = st.pop();
            ans.add(node.val);
            if(node.right != null) {
                root = node.right;
                st.push(root);
            }
            if(st.isEmpty() && root.left == null && root.right == null) break;
        }
        return ans;

    }
}