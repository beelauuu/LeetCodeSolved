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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        //Check if root is null first, if it is return false
        if(root == null) {
            return false;
        }
        //Check if the current root and the subtree are the same tree
        else if(isSameTree(root, subRoot)) {
            return true;
        }
        //Else, check the left and right of the tree.
        else {
            return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
        }
        }
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        //If they're both null, just return true
        if(p == null && q == null) {
            return true;
        }
        //If one of them is null but the other isn't return false
        else if((p == null && q != null) || (p != null && q == null)) {
            return false;
        }
        //Otherwise we know they're both not null, so compare the values
        else {
         //If the values don't match up, we know that it's false so we don't have to keep
         //iterating
         if(p.val != q.val) {
            return false;
        }
        //Otherwise compare the other branches 
        else {
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        }
    }   
    }
}