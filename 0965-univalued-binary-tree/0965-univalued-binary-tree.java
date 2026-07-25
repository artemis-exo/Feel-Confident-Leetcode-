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
    public boolean isUnivalTree(TreeNode root) {
        //return dfs(root);
        Set<Integer>st=new HashSet<>();
        UsingSet(root,st);
        return st.size()==1;
    }
    // public boolean dfs(TreeNode root){
    //     if(root==null)return true;
    //     boolean left=dfs(root.left);
    //     boolean right=dfs(root.right);
    //     if(!left || !right)return false;
    //     if(root.left!=null && root.val!=root.left.val)return false;
    //     if(root.right!=null && root.val!=root.right.val)return false;

    //     return true;
    // }
    // Using Set Data Structure
    public void UsingSet(TreeNode root, Set<Integer>st){
        if(root==null)return;
        UsingSet(root.left,st);
        st.add(root.val);
        UsingSet(root.right,st);
    }
}