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
        //Helper method to convert into a string
        String toSerialize = "";
        toSerialize = helpSerialize(root, toSerialize);
        return toSerialize;
    }
    
    public String helpSerialize(TreeNode root, String rec) {
        if(root == null) {
            return rec += "null,";
        }
        
        //Add the value of the root and then a ",", recursively hitting the whole tree
        rec += root.val+",";
        rec = helpSerialize(root.left, rec);
        rec = helpSerialize(root.right,rec);
        return rec;
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        //Split it into a String array
        String[] arr = data.split(",");
        index = 0;
        return helpDe(arr);
    }
    
    public TreeNode helpDe(String[] data) {
        if(index >= data.length || data[index].equals("null")) {
        //If we go out of bounds we know it's null or there is no other children
            index++;
            return null;
        }
        
        //Else create a new branch and increment the index
        TreeNode toAdd = new TreeNode(Integer.parseInt(data[index]));
        index++;
        
        //Recursively call the left and right
        toAdd.left = helpDe(data); 
        toAdd.right = helpDe(data);
        return toAdd;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec ser = new Codec();
// Codec deser = new Codec();
// TreeNode ans = deser.deserialize(ser.serialize(root));  