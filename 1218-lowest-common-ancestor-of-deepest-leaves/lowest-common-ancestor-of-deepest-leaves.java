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
    public TreeNode lcaDeepestLeaves(TreeNode root) {
        // if(root.left == null && root.right == null) return root;
        // int[] maxDepth1 = new int[1];
        // int[] maxDepth2 = new int[1];
        // int[] leftDec = new int[1];
        // int[] rightDec = new int[1];
        // recRight(root,0,maxDepth1, rightDec);
        // recLeft(root,0,maxDepth2, leftDec);
        // return  ances(root, leftDec, rightDec);
        // ------------------------
        // method 2
        // HashMap<TreeNode, Integer> map = new HashMap<>();
        // dfsMap(root, map);
        // return dfs(root, map);

        // m3
        return singleDfs(root).node;

    }
    // m3 - single dfs - create a pair class - node, and depth
    public Pair singleDfs(TreeNode root){
        if(root == null) return new Pair(root, 0);
        Pair left = singleDfs(root.left);
        Pair right = singleDfs(root.right);

        if(left.depth == right.depth){
            return new Pair(root, left.depth+1);
        } else if(left.depth > right.depth){
            return new Pair(left.node, left.depth+1);
        }

        return new Pair(right.node, right.depth+1);
    }

    // m2
    public TreeNode dfs(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root == null) return root;
        int leftH = root.left != null ? map.get(root.left) : 0;
        int rightH = root.right != null ? map.get(root.right) : 0;
        if(leftH == rightH){
            return root;
        } else if(leftH > rightH){
            return dfs(root.left, map);
        }
        return dfs(root.right, map);
    }
    public int dfsMap(TreeNode root, HashMap<TreeNode, Integer> map){
        if(root == null) return 0;
        int left = dfsMap(root.left, map);
        int right = dfsMap(root.right, map);
        // operation
        int height =1+Math.max(left, right);
        map.put(root, height);
        return height;

    }
    /*
    public TreeNode ances(TreeNode root, int[] p, int[] q){
        if(root == null || root.val == p[0] || root.val == q[0]){
            return root;
        }
        TreeNode left = ances(root.left, p,q);
        TreeNode right = ances(root.right, p, q);

        if(left != null && right != null) return root;

        return left == null ? right : left;

    }
    public void recLeft(TreeNode root, int depth, int[] maxDepth, int[] leftDec){
        if(root == null) return;
        
        // left goes 
        if(depth > maxDepth[0]){
            maxDepth[0] = depth;
            leftDec[0] = root.val;
            System.out.println(depth+ " "+ maxDepth[0] + " val : "+root.val);
            // ans.add(root.val);
        }
        recLeft(root.left, depth+1, maxDepth,leftDec);
        recLeft(root.right, depth+1, maxDepth,leftDec);
    }
    public void recRight(TreeNode root, int depth, int[] maxDepth, int[] rightDec){
        if(root == null) return;
        
        // left goes 
        if(depth > maxDepth[0]){
            maxDepth[0] = depth;
            rightDec[0] = root.val;
            System.out.println(depth+ " "+ maxDepth[0] + " val : "+root.val);
            // ans.add(root.val);
        }
        recRight(root.right, depth+1, maxDepth, rightDec);
        recRight(root.left, depth+1, maxDepth, rightDec);
    }
    */

}

class Pair{
    TreeNode node;
    int depth;
    public Pair(TreeNode node, int depth){
        this.node = node;
        this.depth = depth;
    }
}