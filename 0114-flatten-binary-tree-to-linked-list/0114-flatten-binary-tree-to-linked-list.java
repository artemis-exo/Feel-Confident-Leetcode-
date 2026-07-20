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
    public void flatten(TreeNode root) {
        TreeNode curr=root;
        while(curr!=null){
            if(curr.left!=null){
                // left subTree ka right most dhundho
                TreeNode righty=curr.left;
                while(righty.right!=null){
                    righty=righty.right;
                }
                // curr ka right subTree, righmost ke right mey attach krdo
                righty.right=curr.right;
                // left ko right bnana do,left ko null
                curr.right=curr.left;
                curr.left=null;
            }
            curr=curr.right;
        }
    }
}