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
    public ListNode mergeNodes(ListNode head) {
      ListNode temp=head.next;
      ListNode curr=temp;
      while(curr!=null){
        int sum=0;
        while(curr.val!=0){
            sum+=curr.val;
            curr=curr.next;
        }
        temp.val=sum;
        curr=curr.next;
        temp.next=curr;
        temp=temp.next;
      } 
      return head.next; 
    }
}