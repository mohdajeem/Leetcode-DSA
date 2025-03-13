/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((node1,node2) ->{
            return node1.val - node2.val;
        });
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null){
                pq.add(lists[i]);
            }
        }
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        while(!pq.isEmpty()){
            ListNode newNode= pq.remove();
            temp.next = newNode;
            temp = temp.next;
            if(newNode.next !=null){
                pq.add(newNode.next);
            }
        }
        return dummy.next;

    }
    
}