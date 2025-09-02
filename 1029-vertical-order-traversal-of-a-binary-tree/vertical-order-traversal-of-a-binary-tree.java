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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null) return ans;

        TreeMap<Integer, TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(0,0,root));
        while(!q.isEmpty()){
            Pair p = q.remove();
            int x = p.x;
            int y = p.y;
            TreeNode node = p.node;
            if(!map.containsKey(y)){
                map.put(y, new TreeMap<Integer, PriorityQueue<Integer>>());
            }
            if(!map.get(y).containsKey(x)){
                map.get(y).put(x, new PriorityQueue<Integer>());
            }
            map.get(y).get(x).add(node.val);
            if(node.left != null) q.add(new Pair(x+1,y-1, node.left));
            if(node.right != null) q.add(new Pair(x+1,y+1,node.right));
        }
        for(Integer i : map.keySet()){
            List<Integer> list = new ArrayList<>();
            for(Integer j : map.get(i).keySet()){
                // accesd x wala
                while(!map.get(i).get(j).isEmpty()){
                    list.add(map.get(i).get(j).remove());
                }
            }
            ans.add(new ArrayList<>(list));
        }
        return ans;
    }
}
class Pair{
    int y;
    int x;
    TreeNode node;
    Pair(int x, int y, TreeNode node){
        this.x = x;
        this.y = y;
        this.node = node;
    }
}