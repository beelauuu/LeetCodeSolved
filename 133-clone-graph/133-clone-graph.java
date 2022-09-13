/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    HashMap<Node, Node> oldToNew = new HashMap();
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        
        if(oldToNew.get(node) != null) {
            return oldToNew.get(node);
        }
        
        Node toAdd = new Node(node.val, new ArrayList<Node>());
        oldToNew.put(node, toAdd);
        
        for(Node nodes: node.neighbors) {
            toAdd.neighbors.add(cloneGraph(nodes));
        }
        
        return toAdd;
    }
} 