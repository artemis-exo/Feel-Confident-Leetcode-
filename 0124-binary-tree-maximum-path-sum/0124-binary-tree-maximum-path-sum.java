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
    int res=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        PathSum(root);
        return res;
    }
    public int PathSum(TreeNode root){
        if(root==null)return 0;
       int left= Math.max(PathSum(root.left),0);
        int right=Math.max(PathSum(root.right),0);
        int path=left+right+root.val;
        res=Math.max(res,path);
        return root.val+(Math.max(left,right));
    }
}