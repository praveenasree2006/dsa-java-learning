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
    public boolean isUnivalTree(TreeNode root) {
        if (root == null) return true;

        Queue<TreeNode> q = new LinkedList<>();
        int original = root.val; // Record expected target value 🎯
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode temp = q.poll();

            // Mismatch detected! Not a univalued tree ❌
            if (temp.val != original) return false;

            // Enqueue valid child nodes 🌿
            if (temp.left != null) q.offer(temp.left);
            if (temp.right != null) q.offer(temp.right);
        }

        return true; // All nodes matched! ✅
    }
}