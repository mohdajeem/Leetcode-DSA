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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode ans = new ListNode(-1);
        ListNode dummy = ans;
        ListNode pt1 = list1;
        ListNode pt2 = list2;
        while(pt1 != null && pt2 != null){
            if(pt1.val < pt2.val){
                dummy.next = pt1;
                dummy = dummy.next;
                pt1 = pt1.next;
            } else{
                dummy.next = pt2;
                pt2=pt2.next;
                dummy = dummy.next;
            }
        }
        while(pt1!=null){
            dummy.next = pt1;
            dummy = dummy.next;
            pt1 = pt1.next;
        }
        while(pt2!=null){
            dummy.next = pt2;
            pt2=pt2.next;
            dummy = dummy.next;
        }
        
        return ans.next;
    }
}