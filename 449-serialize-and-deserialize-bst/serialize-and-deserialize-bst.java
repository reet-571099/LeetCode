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

    public void serialize(TreeNode root , StringBuilder sb) {
        if(root==null)
        {
            sb.append("null,");
            return;
        }
        sb.append(root.val+",");
        serialize(root.left,sb);
        serialize(root.right,sb);
    }
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root,sb);
        return sb.toString();
        
    }
    int indx = 0;
    public TreeNode deserialize(String[] arr ) {
if (indx >= arr.length || arr[indx].equals("null")) 
        {
            indx++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(arr[indx++]));
        node.left = deserialize(arr);
        node.right = deserialize(arr);
        return node;

    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        return deserialize(arr);
        
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// String tree = ser.serialize(root);
// TreeNode ans = deser.deserialize(tree);
// return ans;