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
    public boolean isSameTree(TreeNode p, TreeNode q) {
        boolean toReturn = false;
        if(p == null && q == null) {
            return true;
        }
        else if((p == null && q != null) || (p != null && q == null)) {
            toReturn = false;
        }
        else {
         if(p.val != q.val) {
            toReturn = false;
        }
        else {
            toReturn = true;
        }
        }
         return toReturn && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}