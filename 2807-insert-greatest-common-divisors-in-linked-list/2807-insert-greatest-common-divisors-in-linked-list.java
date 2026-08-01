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
    public ListNode insertGreatestCommonDivisors(ListNode head) {
        ListNode curr=head; // Traversal ke liye
        while(curr.next!=null){
            ListNode temp=curr.next; // current se next wali node ko store kara hai
            int gccd=gcd(curr.val,curr.next.val);
            ListNode newNode=new ListNode(gccd);
            curr.next=newNode; // gcd wali node ko curr node ke age link krdiya(a)
            newNode.next=temp; // newNode ke next mey temp ko add krdiya(b) 
            curr=temp;
        }
        return head;
    }
    public int gcd(int a, int b){
        return b==0?a:gcd(b,a%b);
    }
}