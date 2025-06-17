/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return list;
        }

        // Traverse each child in postorder
        for (Node child : root.children) {
            list.addAll(postorder(child));
        }

        // Process the value of the current node
        list.add(root.val);

        return list;
    }
}
