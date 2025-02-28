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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,root));
        while(!q.isEmpty()){
            Pair p = q.remove();
            int x = p.x;
            TreeNode node = p.node;
            if(!map.containsKey(x)){
                map.put(x,node.val);
            }
            if(node.right != null) q.add(new Pair(x+1,node.right));
            if(node.left != null) q.add(new Pair(x+1,node.left));
        }

        for(Integer i : map.keySet()){
            ans.add(map.get(i));
        }
        return ans;
    }
}
class Pair{
    int x;
    TreeNode node;
    public Pair(int x, TreeNode node){
        this.x = x;
        this.node = node;
    }
}