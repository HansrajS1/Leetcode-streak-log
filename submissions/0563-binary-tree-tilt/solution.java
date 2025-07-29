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
    int total = 0;
    
    public int findTilt(TreeNode root) {
        dfs(root);
        return total;
    }
    public int dfs(TreeNode node){ 
        if(node == null) return 0;

        int leftN = dfs(node.left);
        int rigthN = dfs(node.right);

        int tilt = Math.abs(leftN - rigthN);
        total = total + tilt;

        return leftN + rigthN + node.val;
    }
}
