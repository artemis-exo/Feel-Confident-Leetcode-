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
    public int rob(TreeNode root) {
         int ans[]=gain(root);
         return Math.max(ans[0],ans[1]);
    }
    public int[] gain(TreeNode root){
        if(root==null){
            return new int []{0,0};
        }
        int [] left=gain(root.left);
        int [] right=gain(root.right);

        int rob=root.val+left[1]+right[1]; // Jisse node pe khade hai usko toh rob karenge hi right aur left ke not pick wale se values le lenge
        int notRob=Math.max(left[1],left[0])+Math.max(right[1],right[0]);  // ans ko maximize krna hai toh max lenge

        return new int []{rob,notRob};

    }
}