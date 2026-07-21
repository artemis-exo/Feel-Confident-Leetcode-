/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Codec {
     public final String spliter=",";
     public final String NN="X";
     int idx=0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        build(root,sb);
        return sb.toString();
    }
    public void build(TreeNode root, StringBuilder sb){
        if(root==null)
        sb.append(NN).append(spliter);
        else{
            sb.append(root.val).append(spliter);
            build(root.left,sb);
            build(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String [] arr=data.split(spliter);
        return Tree(arr);
    }
    public TreeNode Tree(String [] arr){
        if(arr[idx].equals(NN)){
            idx++;
            return null;
        }
        else{
            TreeNode root=new TreeNode(Integer.parseInt(arr[idx++]));
           root.left= Tree(arr);
           root.right=Tree(arr);
           return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;