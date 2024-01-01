//给定一个二叉树 root ，返回其最大深度。 
//
// 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：root = [1,null,2]
//输出：2
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数量在 [0, 10⁴] 区间内。 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1761 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:二叉树的最大深度

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的最大深度
 * 1. 递归
 * 每次递归，深度加1
 * 返回左右子树的最大深度
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * 2. 迭代
 * 用队列保存每一层的节点
 * 每次遍历一层，将下一层的节点保存到队列中
 * 遍历完一层后，深度加1
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class P104MaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        Solution solution = new P104MaximumDepthOfBinaryTree().new Solution();
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
        public int maxDepth(TreeNode root) {
            //递归
            /*
            if (root == null) {
                return 0;
            }
            int leftDepth = maxDepth(root.left) + 1;
            int rightDepth = maxDepth(root.right) + 1;
            return Math.max(leftDepth, rightDepth);
            */

            //迭代
            if (root == null){
                return 0;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int ans = 0;
            while (!queue.isEmpty()){
                ans ++;
                int size= queue.size();
                for (int i = 0; i < size; i++) {
                    TreeNode node = queue.poll();
                    if (node.left != null){
                        queue.offer(node.left);
                    }
                    if (node.right != null){
                        queue.offer(node.right);
                    }
                }
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}