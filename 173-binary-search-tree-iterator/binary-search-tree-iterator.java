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
    List<Integer> inOrder;
    int pointer;

    public BSTIterator(TreeNode root) {
        inOrder = new ArrayList<>();
        pointer = 0;
        inorder(root,inOrder);
    }
    public void inorder(TreeNode root, List<Integer> inOrder){
        if(root == null) return;
        inorder(root.left, inOrder);
        inOrder.add(root.val);
        inorder(root.right, inOrder);
    }
    
    public int next() {
        int ans = inOrder.get(pointer);
        pointer++;
        return ans;
    }
    
    public boolean hasNext() {
        return pointer < inOrder.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */