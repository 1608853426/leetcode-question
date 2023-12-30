//给定一个二叉树的根节点 root ，返回 它的 中序 遍历 。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,3]
//输出：[1,3,2]
// 
//
// 示例 2： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：root = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// 
//
// 进阶: 递归算法很简单，你可以通过迭代算法完成吗？ 
//
// Related Topics 栈 树 深度优先搜索 二叉树 👍 1993 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//java:二叉树的中序遍历
class P94BinaryTreeInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P94BinaryTreeInorderTraversal().new Solution();
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
/*        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            dfs(root, ans);
            return ans;
        }

        private void dfs(TreeNode root, List<Integer> ans) {
            if (root == null) {
                return;
            }
            dfs(root.left, ans);
            ans.add(root.val);
            dfs(root.right, ans);
        }*/


        /**
         * 迭代遍历
         * 1. 用栈，先把左子树全部入栈，然后出栈，再把右子树入栈
         * 2. 重复1
         * 时间复杂度：O(n)
         * 空间复杂度：O(n)
         * @param root
         * @return
         */
        public List<Integer> inorderTraversal(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null){
                return ans;
            }
            Stack<TreeNode> stack = new Stack<>();
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()){
                if (cur != null){
                    stack.push(cur);
                    while (cur.left != null){
                        stack.push(cur.left);
                        cur = cur.left;
                    }
                }
                TreeNode node = stack.pop();
                ans.add(node.val);
                cur = node.right;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}