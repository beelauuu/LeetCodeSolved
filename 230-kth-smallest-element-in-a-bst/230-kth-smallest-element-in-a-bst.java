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
    public int kthSmallest(TreeNode root, int k) {
        //Using priority queue, add all of the values of the tree and then return/
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        addToQueue(pq, root);
        int toReturn = 0;
        
        //Poll the nth value and then return.
        for(int i = 0; i < k; i++) {
            toReturn = pq.poll();
        }
        
        return toReturn;
    }
    
    public void addToQueue(PriorityQueue pq, TreeNode root) {
        if(root == null) {
            return;
        }
        pq.add(root.val);
        addToQueue(pq, root.left);
        addToQueue(pq, root.right);
    }
}