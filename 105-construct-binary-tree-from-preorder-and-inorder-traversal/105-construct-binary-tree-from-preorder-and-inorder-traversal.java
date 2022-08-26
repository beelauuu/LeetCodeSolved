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
        for(int i = 0; i < inorder.length; i++) {
                mappy.put(inorder[i], i);
            }
        return helper(0,0,inorder.length-1, preorder,inorder);
    }
    
    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if(preStart > preorder.length-1 || inStart > inEnd) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        
        inIndex = mappy.get(root.val);
        
        root.left = helper(preStart+1, inStart, inIndex-1, preorder, inorder);
        root.right = helper(preStart+inIndex-inStart+1, inIndex+1, inEnd, preorder, inorder);
        return root;
    }
}