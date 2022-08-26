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
    HashMap<Integer, Integer> mappy = new HashMap();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
        //Mapping the inorder array for easy access
        for(int i = 0; i < inorder.length; i++) {
                mappy.put(inorder[i], i);
            }
        
        //Returning the helper value.
        return helper(0,0,inorder.length-1, preorder,inorder);
    }
    
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        
        //If preStart goes out bounds or the inStart becomes greater than the end
        if(preStart > preorder.length-1 || inStart > inEnd) {
            return null;
        }
        
        //Creating the new root node from the preorder array
        TreeNode root = new TreeNode(preorder[preStart]);
        
        //inIndex represents the value of the current root
        int inIndex = 0;
        //Getting the root.val from a HashMap
        inIndex = mappy.get(root.val);
        
        
        //For the left, the next value of the left is going to be the +1 value next to preStart
        //inStart is going to be from 0 to the left boundary of the root index
        root.left = helper(preStart+1, inStart, inIndex-1, preorder, inorder);
        
        //For the right, the next value of the right is going to be inIndex-inStart+1 to
        //get to the right child
        //inStart is going to be from the right boundary of the root index to the end
        root.right = helper(preStart+inIndex-inStart+1, inIndex+1, inEnd, preorder, inorder);
        
        //Otherwise, return the root
        return root;
    }
}