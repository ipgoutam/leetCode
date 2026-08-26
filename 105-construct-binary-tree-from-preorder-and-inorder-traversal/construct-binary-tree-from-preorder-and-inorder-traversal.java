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
    private int preIndex = 0;
    private Map<Integer, Integer> inorderMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // Store inorder values with their indices for quick lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        return construct(preorder, 0, inorder.length - 1);
    }

    private TreeNode construct(int[] preorder, int inStart, int inEnd) {
        if (inStart > inEnd) return null;

        // Root from preorder
        TreeNode root = new TreeNode(preorder[preIndex++]);

        // Find root index in inorder
        int inIndex = inorderMap.get(root.val);

        // Build left and right subtrees
        root.left = construct(preorder, inStart, inIndex - 1);
        root.right = construct(preorder, inIndex + 1, inEnd);

        return root;
    }
}