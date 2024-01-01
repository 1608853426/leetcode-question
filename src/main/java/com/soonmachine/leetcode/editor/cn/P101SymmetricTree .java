//给你一个二叉树的根节点 root ， 检查它是否轴对称。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,2,3,4,4,3]
//输出：true
// 
//
// 示例 2： 
// 
// 
//输入：root = [1,2,2,null,3,null,3]
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [1, 1000] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你可以运用递归和迭代两种方法解决这个问题吗？ 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 2619 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:对称二叉树

import java.util.Queue;
import java.util.Stack;

/**
 * 对称二叉树
 * 1. 递归
 * 递归判断左右子树是否对称
 * 左右子树对称的条件： 左右子树的值相等 && 左子树的左子树和右子树的右子树对称 && 左子树的右子树和右子树的左子树对称
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * <p>
 * 2. 迭代
 * 用队列保存每一层的节点
 * 每次遍历一层，将下一层的节点保存到队列中
 * 每次遍历一层，判断是否对称, 如果对称，将下一层的节点保存到队列中, 如果不对称，返回false
 * 对称的条件： 左右子树的值相等 && 左子树的左子树和右子树的右子树对称 && 左子树的右子树和右子树的左子树对称
 */
class P101SymmetricTree {
    public static void main(String[] args) {
        Solution solution = new P101SymmetricTree().new Solution();
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
        public boolean isSymmetric(TreeNode root) {
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root.left);
            stack.push(root.right);
            while (!stack.isEmpty()) {
                TreeNode right = stack.pop();
                TreeNode left = stack.pop();
                if (left == null && right != null) {
                    return false;
                } else if (left != null && right == null) {
                    return false;
                } else if (left != null && right != null && left.val != right.val) {
                    return false;
                } else if (left != null && right != null) {
                    stack.push(left.left);
                    stack.push(right.right);
                    stack.push(left.right);
                    stack.push(right.left);
                }
            }
            return true;

        }

        boolean check(TreeNode left, TreeNode right) {
            if (left == null && right != null) {
                return false;
            } else if (left != null && right == null) {
                return false;
            } else if (left != null && right != null && left.val != right.val) {
                return false;
            } else if (left == null && right == null) {
                return true;
            } else {
                return check(left.left, right.right) && check(left.right, right.left);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}