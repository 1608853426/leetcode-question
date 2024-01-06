//给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的
//根节点的引用。 
//
// 一般来说，删除节点可分为两个步骤： 
//
// 
// 首先找到需要删除的节点； 
// 如果找到了，删除它。 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入：root = [5,3,6,2,4,null,7], key = 3
//输出：[5,4,6,2,null,null,7]
//解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
//一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
//另一个正确答案是 [5,2,6,null,4,null,7]。
//
//
// 
//
// 示例 2: 
//
// 
//输入: root = [5,3,6,2,4,null,7], key = 0
//输出: [5,3,6,2,4,null,7]
//解释: 二叉树不包含值为 0 的节点
// 
//
// 示例 3: 
//
// 
//输入: root = [], key = 0
//输出: [] 
//
// 
//
// 提示: 
//
// 
// 节点数的范围 [0, 10⁴]. 
// -10⁵ <= Node.val <= 10⁵ 
// 节点值唯一 
// root 是合法的二叉搜索树 
// -10⁵ <= key <= 10⁵ 
// 
//
// 
//
// 进阶： 要求算法时间复杂度为 O(h)，h 为树的高度。 
//
// Related Topics 树 二叉搜索树 二叉树 👍 1293 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:删除二叉搜索树中的节点

/**
 * 删除二叉搜索树中的节点
 * 递归
 * 1. 递归终止条件：root==null
 * 2. 递归过程：如果key<root.val，递归左子树
 * 如果key>root.val，递归右子树
 * 如果key==root.val，分三种情况
 * 1. 如果root.left==null，说明root是叶子节点，直接返回root.right
 * 2. 如果root.right==null，说明root是叶子节点，直接返回root.left
 * 3. 如果root.left!=null && root.right!=null，说明root有左右子树，
 * 找到root.right的最小节点，将root.val替换为最小节点的值，递归删除root.right的最小节点
 * 3. 递归返回值：返回root
 * 时间复杂度：O(h)，h为树的高度
 * 空间复杂度：O(h)，h为树的高度
 */
class P450DeleteNodeInABst {
    public static void main(String[] args) {
        Solution solution = new P450DeleteNodeInABst().new Solution();
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
        public TreeNode deleteNode(TreeNode root, int key) {
            // 递归终止条件
            if (root == null) {
                return null;
            }
            // 递归过程
            if (key < root.val) {
                root.left = deleteNode(root.left, key);
            } else if (key > root.val) {
                root.right = deleteNode(root.right, key);
            } else {
                // 递归返回值
                if (root.left == null) {
                    return root.right;
                } else if (root.right == null) {
                    return root.left;
                } else {
                    TreeNode minNode = root.right;
                    while (minNode.left != null) {
                        minNode = minNode.left;
                    }
                    root.val = minNode.val;
                    root.right = deleteNode(root.right, minNode.val);
                }
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}