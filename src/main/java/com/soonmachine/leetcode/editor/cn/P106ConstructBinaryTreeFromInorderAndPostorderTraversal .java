//给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并
//返回这颗 二叉树 。 
//
// 
//
// 示例 1: 
// 
// 
//输入：inorder = [9,3,15,20,7], postorder = [9,15,7,20,3]
//输出：[3,9,20,null,null,15,7]
// 
//
// 示例 2: 
//
// 
//输入：inorder = [-1], postorder = [-1]
//输出：[-1]
// 
//
// 
//
// 提示: 
//
// 
// 1 <= inorder.length <= 3000 
// postorder.length == inorder.length 
// -3000 <= inorder[i], postorder[i] <= 3000 
// inorder 和 postorder 都由 不同 的值组成 
// postorder 中每一个值都在 inorder 中 
// inorder 保证是树的中序遍历 
// postorder 保证是树的后序遍历 
// 
//
// Related Topics 树 数组 哈希表 分治 二叉树 👍 1159 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:从中序与后序遍历序列构造二叉树

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 从中序与后序遍历序列构造二叉树
 * 1. 递归
 * 后序遍历的最后一个节点是根节点
 * 在中序遍历中找到根节点，根节点左边的是左子树，右边的是右子树
 * 递归构造左右子树
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * 2. 迭代
 * 迭代构造左右子树
 * 具体过程
 * 1. 从后序遍历的最后一个元素开始，作为根节点
 * 2. 从中序遍历中找到根节点，根节点左边的是左子树，右边的是右子树
 * 3. 从后序遍历中找到左右子树的根节点，左子树的根节点是后序遍历的倒数第二个元素，右子树的根节点是后序遍历的倒数第三个元素
 * 4. 重复2，3步骤
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class P106ConstructBinaryTreeFromInorderAndPostorderTraversal{
    public static void main(String[] args){
        Solution solution = new P106ConstructBinaryTreeFromInorderAndPostorderTraversal().new Solution();
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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //中序遍历的结果为空，说明没了
        if (inorder.length == 0){
            return null;
        }
        int nodeVal = postorder[postorder.length - 1];
        TreeNode node = new TreeNode(nodeVal);
        int i;
        for (i = 0; i < inorder.length; i++) {
            if (inorder[i] == nodeVal){
                break;
            }
        }
        int[] leftIn = Arrays.copyOfRange(inorder, 0 , i);
        int[] rightIn = Arrays.copyOfRange(inorder, i + 1, inorder.length);
        int[] leftPo = Arrays.copyOfRange(postorder, 0, i);
        int[] rightPo = Arrays.copyOfRange(postorder, i, postorder.length - 1);
        node.left = buildTree(leftIn, leftPo);
        node.right = buildTree(rightIn, rightPo);
        return node;
        }

    }

//leetcode submit region end(Prohibit modification and deletion)

}