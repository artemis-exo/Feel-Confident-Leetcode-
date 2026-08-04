/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 // Using Set

public class Solution {
    public ListNode detectCycle(ListNode head) {
        Set<ListNode> st=new HashSet<>();
        ListNode temp=head;
        while(temp!=null){
            if(st.contains(temp)){
                return temp;
            }
            st.add(temp);
            temp=temp.next;
        }
        return null;
    }
}

// Using Tortoise and Hare
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(fast==slow){
               ListNode start=head;
               while(start!=slow){
                start=start.next;
                slow=slow.next;
               }
               return slow;
            }
        }
        return null;
    }
}
