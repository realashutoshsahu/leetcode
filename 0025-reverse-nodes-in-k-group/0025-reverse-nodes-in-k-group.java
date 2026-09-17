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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode current = temp;

        while (true) {
            // Finnd the kth node
            ListNode kth = current;

            for (int i = 0; i < k; i++){
                kth = kth.next;

                if (kth == null){
                    return temp.next;
                }
            }

            ListNode groupNext = kth.next;
            // Reverse the group
            ListNode prev = groupNext;
            ListNode node = current.next;

            while (node != groupNext){

                ListNode next = node.next;
                node.next = prev;
                prev = node;
                node = next;
            }

            // Connect previous part with reversed group
            ListNode first = current.next;
            current.next = kth;

            current = first;
        }
    }
}