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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode t = dummy;
        ListNode t1 = l1;
        ListNode t2 = l2;
        int carry = 0;
        while(t1 != null && t2 != null){
            int sum = t1.val+t2.val+carry;
            carry = sum/10;
            t.next = new ListNode(sum%10);
            t1 = t1.next;
            t2 = t2.next;
            t = t.next;
        }
        while(t1!=null){
            int sum = t1.val + carry;
            carry = sum/10;
            t.next = new ListNode(sum%10);
            t = t.next;
            t1 = t1.next;
        }
        while(t2!=null){
            int sum = t2.val + carry;
            carry = sum/10;
            t.next = new ListNode(sum%10);
            t = t.next;
            t2 = t2.next;
        }
        if(carry != 0){
            t.next = new ListNode(carry);
        }
        return dummy.next;
    }
}