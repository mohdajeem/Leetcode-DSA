/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> map = new HashMap<>();
        findParent(root, map);
        Queue<Pair> q = new LinkedList<>();
        HashSet<TreeNode> vis = new HashSet<>();
        q.add(new Pair(target, 0));
        vis.add(target);
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            Pair p =q.remove();
            TreeNode node = p.node;
            int dis = p.dis;
            if(dis == k){
                ans.add(node.val);
                continue;
            }
            if(node.left != null && !vis.contains(node.left)){
                q.add(new Pair(node.left, dis+1));
                vis.add(node.left);
            }
            if(node.right != null && !vis.contains(node.right)){
                q.add(new Pair(node.right, dis+1));
                vis.add(node.right);
            }
            if(map.containsKey(node) && map.get(node)!=null && !vis.contains(map.get(node))){
                q.add(new Pair(map.get(node), dis+1));
                vis.add(map.get(node));
            }
        }
        return ans;

    }

    public void findParent(TreeNode root, HashMap<TreeNode, TreeNode> map){
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(node.left != null){
                map.put(node.left, node);
                q.add(node.left);
            }
            if(node.right != null){
                map.put(node.right, node);
                q.add(node.right);
            }
        }
    }
}
class Pair{
    TreeNode node;
    int dis;
    public Pair(TreeNode node, int dis){
        this.node = node;
        this.dis = dis;
    }
}