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
    int max = 0;
    public int[] findMode(TreeNode root) {
        HashMap<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> ans = new ArrayList<>();
        for(int key : map.keySet()){
            if(map.get(key) == max){
                ans.add(key);
            }
        }
        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
    public void dfs(TreeNode root, HashMap<Integer, Integer> map){
        if(root == null) return;
        // have to perform some task
        map.put(root.val, map.getOrDefault(root.val,0)+1);
        max = Math.max(map.get(root.val), max);
        if(root.left != null){
            dfs(root.left,map);
        }
        if(root.right != null){
            dfs(root.right, map);
        }
    }
}