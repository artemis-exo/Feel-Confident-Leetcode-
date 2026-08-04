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
    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp=head;
        while(temp!=null && temp.next!=null){
            if(temp.val==temp.next.val){
                temp.next=temp.next.next;
            }
            else{
                 temp=temp.next; // more than one duplicate hoga uske liye kyu ki agr elese nhi likhenge toh yeh har baar next mey jayega or 1 se jyada duplicate miss ho skte hai
            }
            
        }
        return head;
    }
}