//给定一个二叉树，找出其最小深度。 
//
// 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。 
//
// 说明：叶子节点是指没有子节点的节点。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：root = [2,null,3,null,4,null,5,null,6]
//输出：5
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数的范围在 [0, 10⁵] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1143 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:二叉树的最小深度

import java.util.Deque;
import java.util.LinkedList;

/**
 * 二叉树的最小深度
 * 1. 递归
 * 每次递归，深度加1
 * 返回左右子树的最小深度
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * <p>
 * 2. 迭代
 * 用队列保存每一层的节点
 * 每次遍历一层，将下一层的节点保存到队列中
 * 如果当前节点的左右子节点都为空，说明是叶子节点，返回当前深度
 * 遍历完一层后，深度加1
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class P111MinimumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P111MinimumDepthOfBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     * int val;
     * TreeNode left;
     * TreeNode right;
     * TreeNode() {}
     * TreeNode(int val) { this.val = val; }
     * TreeNode(int val, TreeNode left, TreeNode right) {
     * this.val = val;
     * this.left = left;
     * this.right = right;
     * }
     * }
     */
    class Solution {
        public int minDepth(TreeNode root) {
            // 递归
/*        if (root == null) {
            return 0;
        }
        int left = minDepth(root.left);
        int right =minDepth(root.right);
        if (left == 0 || right == 0) {
            return left + right + 1;
        }
        return Math.min(left, right) + 1;
    */
            // 迭代
            if (root == null) {
                return 0;
            }
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int depth = 0;
            while (!queue.isEmpty()) {
                depth++;
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left == null && node.right == null) {
                        return depth;
                    }
                    if (node.left != null) {
                        queue.offer(node.left);
                    }
                    if (node.right != null) {
                        queue.offer(node.right);
                    }

                }
            }
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}