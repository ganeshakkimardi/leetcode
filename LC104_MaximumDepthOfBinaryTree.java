package practise.leetCode;

import java.util.LinkedList;
import java.util.Queue;

public class LC104_MaximumDepthOfBinaryTree {

    // Definition for a binary tree node.
//    static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        TreeNode(int val) {
//            this.val = val;
//        }
//    }

    public static void main(String[] args) {
        // Input: [3,9,20,null,null,15,7]
        Integer[] arr = {3, 9, 20, null, null, 15, 7};
        TreeNode root = buildTree(arr);

        LC104_MaximumDepthOfBinaryTree obj =
                new LC104_MaximumDepthOfBinaryTree();

        int result = obj.maxDepth(root);
        System.out.println("Output: " + result); // Expected: 3
    }

    public int maxDepth(TreeNode root) {
        if(root == null)
            return 0;

        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    // Helper method to build tree from level-order array
    private static TreeNode buildTree(Integer[] arr) {
        if (arr == null || arr.length == 0 || arr[0] == null) return null;

        TreeNode root = new TreeNode(arr[0]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int i = 1;
        while (i < arr.length) {
            TreeNode current = queue.poll();

            if (arr[i] != null) {
                current.left = new TreeNode(arr[i]);
                queue.offer(current.left);
            }
            i++;

            if (i < arr.length && arr[i] != null) {
                current.right = new TreeNode(arr[i]);
                queue.offer(current.right);
            }
            i++;
        }
        return root;
    }
}
