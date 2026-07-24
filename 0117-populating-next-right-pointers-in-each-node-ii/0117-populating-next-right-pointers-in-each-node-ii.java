/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
      Queue<Node>pq=new LinkedList<>();
        if(root==null)
        return null;
        pq.offer(root);
        while(!pq.isEmpty()){
            int size=pq.size();
            for(int i=0; i<size; i++){
                Node curr=pq.poll();
                if(i<size-1){ // humko null explictly add nhi karna padega because .next pointer by default null store krta  hai
                    curr.next=pq.peek(); // yeh base null ke bina walo ka phele connection bna rha hai
                }
                if(curr.left!=null)
                pq.offer(curr.left);
                if(curr.right!=null)
                pq.offer(curr.right);
            }
        }
        return root;  
    }
}