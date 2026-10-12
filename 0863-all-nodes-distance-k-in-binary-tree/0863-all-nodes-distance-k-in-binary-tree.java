/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        List<Integer>li=new ArrayList<>();
        Map<TreeNode, TreeNode>par=new HashMap<>(); // Parent map issliye bnaya  kyu leetcode ke treeNode Implementation mey hum par ki side traverse nhi kar skte hai
        // ---  >> Toh Map har node ka par key val pair mey store karta hai
        buildPar(root,null,par);
        Queue<TreeNode>pq=new LinkedList<>();
        pq.add(target);
        Set<TreeNode>visit=new HashSet<>(); // set visited ke liye doobara dusre node pe na jaye 
        visit.add(target);
        int dist=0;
        while(!pq.isEmpty()){
            if(k==dist){ // jaise hi == waise hi break kyu ki Queue ke pass sare k dist wale hi store honge
                break;
            }
            int size=pq.size();
            for(int i=0; i<size; i++){
                TreeNode curr=pq.poll();
                if(curr.left!=null && visit.add(curr.left)){ // yeh left ke liye traverse
                    pq.offer(curr.left);
                }
                if(curr.right!=null && visit.add(curr.right)){ // this one for right traverse
                    pq.offer(curr.right);
                }
                TreeNode peri=par.get(curr);
                if(peri!=null && visit.add(peri)){ // This one for Parent one  
                    pq.offer(peri);
                }
            }
                dist++;
        }
        for(TreeNode i:pq){
            li.add(i.val);
        }
        return li;
    }
    public void buildPar(TreeNode root, TreeNode par, Map<TreeNode,TreeNode>map){
        if(root==null){
            return;
        }
        map.put(root,par);
        buildPar(root.left,root,map);
        buildPar(root.right,root,map);
    }

}