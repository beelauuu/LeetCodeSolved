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
    HashMap<Node, Node> oldToNew = new HashMap<Node, Node>();
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        
        if(oldToNew.containsKey(node)) {
            return oldToNew.get(node);
        }
        Node newNode = new Node(node.val, new ArrayList<Node>());
        oldToNew.put(node, newNode);
        for(Node neighbors: node.neighbors) {
            newNode.neighbors.add(cloneGraph(neighbors));
        }
        return newNode;
        }
} 