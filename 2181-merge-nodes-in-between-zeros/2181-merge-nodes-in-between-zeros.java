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

// In O(1) Space Without dummy node 
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

// Using Dummy Node
class Solution {
    public ListNode mergeNodes(ListNode head) {
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        head = head.next;
        int curSum = 0;
        while(head!=null) {
            curSum =0;
            while(head.val != 0) {
                curSum+=head.val;
                head = head.next;
            }
            ListNode add=new ListNode(curSum);
            temp.next=add;
            temp=temp.next;
            head=head.next;
           
        }
        return dummy.next;
    }
}
