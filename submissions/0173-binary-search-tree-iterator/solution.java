import java.util.Stack;

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
class BSTIterator {
    private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        leftMostInorder(root);
    }
    
    private void leftMostInorder(TreeNode root) {
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
    }
    
    public int next() {
        TreeNode topNode = stack.pop();
        
        if (topNode.right != null) {
            leftMostInorder(topNode.right);
        }
        
        return topNode.val;
    }
    
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}
