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
    public TreeNode invertTree(TreeNode root) {
        //Check if the root is null
        if(root == null) {
            return null;
        }
        //Otherwise iterate until you reach the bottom
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        
        //Literally just swap the left and right
        root.right = left;
        root.left = right;
        
        //Return the root
        return root;
    }
}