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
class BSTIterator {
    private Stack<TreeNode> st = new Stack<>();

    public BSTIterator(TreeNode root) {
        iterateLeft(root);
    }
    public void iterateLeft(TreeNode root){
        while(root!= null){
            st.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        if(st.isEmpty()) return -1;
        TreeNode root = st.pop();
        int val = root.val;
        if(root.right!=null){
            root = root.right;
            iterateLeft(root);
        }
        return val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */