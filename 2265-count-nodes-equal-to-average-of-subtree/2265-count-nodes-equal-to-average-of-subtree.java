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

 /* 
 1 ----.> Traverse Helper func se har node a sum or count nkalte rhenge
 2----- > Then phir simple findSum ka simple recursive function build karenge and call
 3 ---- > Same for COunt also nodes count a ek seperate func 
 4 ----- > Dono func se sum or count ki values jo ayemgi unse Avg niklate rehnge aur Condtion satisfy hui of cnt ++

----- >>> This is my Game plan for solving this 
 */
class Solution {
    int ans=0;
    public int averageOfSubtree(TreeNode root) {
        traverse(root);
        return ans;
    }
    public void traverse(TreeNode root){
        if(root==null)
        return;
        int sum=findSum(root);
        int count=Count(root);
        if(sum/count==root.val)
        ans++;
        traverse(root.left);
        traverse(root.right);
    }
    public int findSum(TreeNode root){
        if(root==null)
        return 0;
        return root.val+findSum(root.left)+findSum(root.right);
    }
    public int Count(TreeNode root){
        if(root==null)
        return 0;
        return  1+Count(root.left) + Count(root.right);
    }
}


// OPTIMIZED APPROACH FOR THIS 

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
    int res=0;
    public int averageOfSubtree(TreeNode root) {
        Calculate (root);
        return res;
    }
    public int [] Calculate(TreeNode root){
        if(root==null)
        return new int []{0, 0};
        
        int [] left=Calculate(root.left);
        int [] right=Calculate(root.right);
        int sum = root.val+left[0]+ right[0];
        int count =1+ left[1] + right[1];
        if(sum/count==root.val)
        res++;
        
        return new int []{sum, count};
   }
    
    }
