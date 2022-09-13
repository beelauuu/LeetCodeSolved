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
    int index = 0;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder toSerialize = new StringBuilder();
        helpSerialize(root, toSerialize);
        return toSerialize.toString();
    }
    
    public void helpSerialize(TreeNode root, StringBuilder rec) {
        if(root == null) {
            rec.append("null,");
            return;
        }
        
        rec.append(root.val+",");
        helpSerialize(root.left, rec);
        helpSerialize(root.right,rec);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        index = 0;
        return helpDe(arr);
    }
    
    public TreeNode helpDe(String[] data) {
        if(index >= data.length || data[index].equals("null")) {
            index++;
            return null;
        }
        
        TreeNode toAdd = new TreeNode(Integer.parseInt(data[index]));
        index++;
        toAdd.left = helpDe(data); 
        toAdd.right = helpDe(data);
        return toAdd;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));  