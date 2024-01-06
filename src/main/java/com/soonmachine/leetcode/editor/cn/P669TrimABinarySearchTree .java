//给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不
//应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。 
//
// 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,0,2], low = 1, high = 2
//输出：[1,null,2]
// 
//
// 示例 2： 
// 
// 
//输入：root = [3,0,4,null,2,null,null,1], low = 1, high = 3
//输出：[3,2,null,1]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数在范围 [1, 10⁴] 内 
// 0 <= Node.val <= 10⁴ 
// 树中每个节点的值都是 唯一 的 
// 题目数据保证输入是一棵有效的二叉搜索树 
// 0 <= low <= high <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 899 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:修剪二叉搜索树

/**
 *  修剪二叉搜索树
 *  递归
 *  1. 递归终止条件：root==null
 *  2. 递归过程：递归左子树，递归右子树
 *  3. 递归返回值：如果root.val<low，说明root和左子树都不符合要求，返回右子树
 *  如果root.val>high，说明root和右子树都不符合要求，返回左子树
 *  如果root.val在[low,high]之间，说明root符合要求，递归左右子树
 *  时间复杂度：O(n)
 *  空间复杂度：O(n)
 */
class P669TrimABinarySearchTree{
    public static void main(String[] args){
        Solution solution = new P669TrimABinarySearchTree().new Solution();
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
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null){
            return null;
        }
        if (root.val < low){
            return trimBST(root.right, low, high);
        }else if (root.val > high){
            return trimBST(root.left, low, high);
        }else {
            root.left = trimBST(root.left, low,high);
            root.right = trimBST(root.right, low, high);
            return root;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}