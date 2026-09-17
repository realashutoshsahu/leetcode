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
    public ListNode swapPairs(ListNode head) {
        
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode current = temp;

        while ( current.next != null && current.next.next != null){

            ListNode first = current.next;
            ListNode second = current.next.next;
            
            first.next = second.next;
            second.next = first;
            current.next = second;

            current = first;

        }
        return temp.next;
    }
}