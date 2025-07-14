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
    public int getDecimalValue(ListNode head) {
        ListNode temp = head;
        int dig = 0;
        while(temp != null){
            dig++;
            temp = temp.next;
        }
        int ans = 0;
        dig--;
        temp = head;
        while(temp != null){
            ans += (temp.val)*(int)(Math.pow(2, dig));
            dig--;
            temp = temp.next;
        }
        return ans;
        
    }
}