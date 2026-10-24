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
import java.util.*;

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int result = root.val;

        while (!queue.isEmpty()) {
            TreeNode current = queue.poll();

            // Add right child first
            if (current.right != null) {
                queue.offer(current.right);
            }

            // Add left child second
            if (current.left != null) {
                queue.offer(current.left);
            }

            result = current.val;
        }

        return result;
    }
}