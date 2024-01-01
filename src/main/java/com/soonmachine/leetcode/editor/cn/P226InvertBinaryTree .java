//给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [4,2,7,1,3,6,9]
//输出：[4,7,2,9,6,3,1]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [2,1,3]
//输出：[2,3,1]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目范围在 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1752 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:翻转二叉树

import java.util.LinkedList;
import java.util.Queue;

/**
 * 翻转二叉树
 * 1. 递归
 * 交换左右子树
 * 递归左右子树
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * 2. 迭代
 * 用队列保存每一层的节点
 * 每次遍历一层，将下一层的节点保存到队列中
 * 每次遍历一层，交换左右子树
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class P226InvertBinaryTree{
    public static void main(String[] args){
        Solution solution = new P226InvertBinaryTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
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
    public TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }
        bfs(root);
        return root;
    }

    void dfs(TreeNode node){
        if (node == null){
            return;
        }
        TreeNode tmp = node.left;
        node.left = node.right;
        node.right = tmp;
        dfs(node.left);
        dfs(node.right);
    }

    void bfs(TreeNode node){
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(node);
        while (!queue.isEmpty()){
            int size = queue.size();
            while (size -- > 0){
                TreeNode cur = queue.poll();
                TreeNode left = cur.left;
                TreeNode right = cur.right;
                cur.right = left;
                cur.left = right;
                if (right != null){
                    queue.offer(right);
                }
                if (left != null){
                    queue.offer(left);
                }
            }
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}