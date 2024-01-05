//给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并
//返回其根节点。 
//
// 
//
// 示例 1: 
// 
// 
//输入: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
//输出: [3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入: preorder = [-1], inorder = [-1]
//输出: [-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= preorder.length <= 3000 
// inorder.length == preorder.length 
// -3000 <= preorder[i], inorder[i] <= 3000 
// preorder 和 inorder 均 无重复 元素 
// inorder 均出现在 preorder 
// preorder 保证 为二叉树的前序遍历序列 
// inorder 保证 为二叉树的中序遍历序列 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 2172 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:从前序与中序遍历序列构造二叉树

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 从前序与中序遍历序列构造二叉树
 * 1. 递归
 * 前序遍历的第一个节点是根节点
 * 在中序遍历中找到根节点，根节点左边的是左子树，右边的是右子树
 * 递归构造左右子树
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 * <p>
 * 2. 迭代
 * 迭代构造左右子树
 * 具体过程
 * 1. 从前序遍历的第一个元素开始，作为根节点
 * 2. 从中序遍历中找到根节点，根节点左边的是左子树，右边的是右子树
 * 3. 从前序遍历中找到左右子树的根节点，左子树的根节点是前序遍历的第二个元素，右子树的根节点是前序遍历的第三个元素
 * 4. 重复2，3步骤
 */
class P105ConstructBinaryTreeFromPreorderAndInorderTraversal {
    public static void main(String[] args) {
        Solution solution = new P105ConstructBinaryTreeFromPreorderAndInorderTraversal().new Solution();
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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            //迭代方法
            if (preorder.length == 0) {
                return null;
            }
            Deque<TreeNode> stack = new LinkedList<>();
            TreeNode root = new TreeNode(preorder[0]);
            stack.push(root);
            int inorderIndex = 0;
            for (int i = 1; i < preorder.length; i++) {
                //前序遍历的第一个元素是根节点，所以从第二个元素开始
                int preorderVal = preorder[i];
                //找到根节点
                TreeNode node = stack.peek();
                //如果根节点的值不等于中序遍历的值，说明根节点的左子树还没遍历完
                if (node.val != inorder[inorderIndex]) {
                    //构造左子树
                    node.left = new TreeNode(preorderVal);
                    //将左子树的根节点入栈
                    stack.push(node.left);
                //如果根节点的值等于中序遍历的值，说明根节点的左子树已经遍历完了，开始构造右子树
                } else {
                    //将栈中的节点弹出，直到栈顶的节点的值不等于中序遍历的值
                    while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                        //弹出的节点就是根节点
                        node = stack.pop();
                        //中序遍历的索引加一
                        inorderIndex++;
                    }
                    //构造右子树, 将右子树的根节点入栈
                    node.right = new TreeNode(preorderVal);
                    stack.push(node.right);
                }
            }
            return root;
        }

        // Encodes a tree to a single string.
        String serialize(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            if (root == null){
                return ans.toString();
            }
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                while (size -- > 0){
                    TreeNode node = queue.poll();
                    if (node == null){
                        ans.add(null);
                    }else {
                        ans.add(node.val);
                        queue.offer(node.left);
                        queue.offer(node.right);
                    }
                }
            }
            return ans.toString();
        }

        // Decodes your encoded data to tree.
        TreeNode deserialize(String data) {
            data = data.replaceAll(" ", "");
            if (data.equals("[]")){
                return null;
            }
            String[] nodes = data.substring(1, data.length() - 1).split(",");
            TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
            Deque<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            int i = 1;
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if (!nodes[i].equals("null")){
                    node.left = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.offer(node.left);
                }
                i++;
                if (!nodes[i].equals("null")){
                    node.right = new TreeNode(Integer.parseInt(nodes[i]));
                    queue.offer(node.right);
                }
                i++;
            }
            return root;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}