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
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        getHeight(root);
        return diameter;
    }
    private int getHeight(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int leftH = getHeight(root.left);
            int rightH = getHeight(root.right);

            diameter = Math.max(diameter, leftH + rightH);
            return Math.max(leftH, rightH) +1;
        }
    }
}