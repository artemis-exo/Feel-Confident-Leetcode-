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
    int moves=0;
    public int distributeCoins(TreeNode root) {
        Coins(root);
        return moves;
    }
    public int Coins(TreeNode root){
        if(root==null)return 0;
        int left=Coins(root.left);
        int right=Coins(root.right);
        int donate=left+right-1+root.val;
        moves+=Math.abs(left)+Math.abs(right);
        return donate;
    }
}