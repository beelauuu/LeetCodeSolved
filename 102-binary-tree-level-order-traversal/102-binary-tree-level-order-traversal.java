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
    public List<List<Integer>> levelOrder(TreeNode root) {
    //Node levelOrder is just a fancy term for BFS
        
        //Value to return
        List<List<Integer>> list = new ArrayList<>();
        
        //If the root is null, we can just return an empty list
        if(root == null) {
            return list;
        }
        
        
        //Otherwise create your queue and add your root
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        
        //While it's not empty
        while(!queue.isEmpty()) {
            //We can have a size value for each level and a list for each level
            int size = queue.size();
            List<Integer> currLevel = new ArrayList<>();
            
            //Iterate through all the nodes on each level removing from queue and adding it
            //to the curr level
            for(int i = 0; i < size; i++) {
                TreeNode curr = queue.remove();
                currLevel.add(curr.val);
                
                //If it's got children, add the left and right to the queue
                if(curr.left != null) {
                    queue.add(curr.left);
                }
                if(curr.right != null) {
                    queue.add(curr.right);
                }
            }
            
            //Finally add the list to the returner
            list.add(currLevel);
        }
        
        return list;
    }
}