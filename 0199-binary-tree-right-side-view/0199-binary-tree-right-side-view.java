/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
       // Using DFS
       List<Integer>li=new ArrayList<>();
       levels(root,0,li);
       return li;

    }
    public void levels( TreeNode root, int level,  List<Integer>li ){
        if(root==null)
        return;
        if(level==li.size()){
            li.add(root.val);
        }
        levels(root.right, level+1, li);
        levels(root.left, level+1,li);
    }
}