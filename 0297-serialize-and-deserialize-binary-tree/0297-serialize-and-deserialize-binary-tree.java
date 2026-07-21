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
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb=new StringBuilder();
        build(root,sb);
        return sb.toString();
    }
    public void build(TreeNode root, StringBuilder sb){
        if(root==null){
        sb.append(NN).append(spliter);
        return;
        }
        else{
            sb.append(root.val).append(spliter);
            build(root.left,sb);
            build(root.right,sb);
        }
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
       Deque<String> d=new LinkedList<>();
       d.addAll(Arrays.asList(data.split(spliter)));
       return Tree(d); 
    }
    public TreeNode Tree(Deque<String>d){
        String val=d.remove();
        if(val.equals(NN))return null;
        else{
            TreeNode root=new TreeNode(Integer.parseInt(val));
           root.left= Tree(d);
           root.right= Tree(d);
           return root;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));