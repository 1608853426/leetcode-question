//给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。 
//
// 叶子节点 是指没有子节点的节点。 
//
// 示例 1： 
// 
// 
//输入：root = [1,2,3,null,5]
//输出：["1->2->5","1->3"]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：["1"]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 100] 内 
// -100 <= Node.val <= 100 
// 
//
// Related Topics 树 深度优先搜索 字符串 回溯 二叉树 👍 1081 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.LinkedList;
import java.util.List;

//java:二叉树的所有路径

/**
 * 二叉树的所有路径
 * 1. 递归
 * 每次递归，将当前节点加入到路径中
 * 如果当前节点是叶子节点，将路径加入到结果中
 * 递归左右子树
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class P257BinaryTreePaths{
    public static void main(String[] args){
        Solution solution = new P257BinaryTreePaths().new Solution();
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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new LinkedList<>();
        if (root == null) {
            return res;
        }
        dfs(root, "", res);
        return res;
    }

    void dfs(TreeNode node, String path, List<String> res){
        if (node.left == null && node.right == null){
            path += node.val;
            res.add(path);
            return;
        }
        path +=  node.val + "->";
        if (node.left != null) {
            dfs(node.left,path, res);
        }
        if (node.right != null) {
            dfs(node.right, path, res);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}