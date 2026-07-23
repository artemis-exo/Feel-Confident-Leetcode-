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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<int[]>li=new ArrayList<>();
        vertical(root,0,0,li);
        li.sort((a,b)->{
           if(a[0]!=b[0]) return Integer.compare(a[0],b[0]); // col-wise left se right
           if(a[1]!=b[1]) return Integer.compare(a[1],b[1]); // jab col same honge tab Row-wise(top-bottom)
           return Integer.compare(a[2],b[2]); // node ki val wise jab dono Row, Col same honge
        });
        List<List<Integer>>res=new ArrayList<>();
        int prevHold=Integer.MIN_VALUE;
        for(int i[]:li){
            int col=i[0] , row=i[1], val=i[2];
            if(col!=prevHold){   // col same hai toh new ArrayList bnao aur prevHold val mey reference daldo
                res.add(new ArrayList<>());
                prevHold=col;
            }
            res.get(res.size()-1).add(val);
        }
        return res;
    }
    public void vertical(TreeNode root, int col, int row, List<int[]> li){
        if(root==null)return;
        li.add(new int[]{col,row,root.val});
        vertical(root.left,col-1,row+1,li);
        vertical(root.right,col+1,row+1,li);
    }
}
