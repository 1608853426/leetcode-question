//给定一个二叉树的根节点 root ，和一个整数 targetSum ，求该二叉树里节点值之和等于 targetSum 的 路径 的数目。 
//
// 路径 不需要从根节点开始，也不需要在叶子节点结束，但是路径方向必须是向下的（只能从父节点到子节点）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [10,5,-3,3,2,null,11,3,-2,null,1], targetSum = 8
//输出：3
//解释：和等于 8 的路径有 3 条，如图所示。
// 
//
// 示例 2： 
//
// 
//输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
//输出：3
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [0,1000] 
// 
// -10⁹ <= Node.val <= 10⁹ 
// -1000 <= targetSum <= 1000 
// 
//
// Related Topics 树 深度优先搜索 二叉树 👍 1770 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:路径总和 III

/**
 * 1. 递归
 *  递归遍历每个节点，计算以当前节点为根节点的路径和
 *  递归遍历左右子树，计算以左右子树为根节点的路径和
 * 2. 前缀和
 * 从根节点到当前节点的路径和为sum
 * 从根节点到某个节点的路径和为sum - targetSum
 * 从某个节点到当前节点的路径和为targetSum
 *
 */
class P437PathSumIii{
    public static void main(String[] args){
        Solution solution = new P437PathSumIii().new Solution();
        int tmp = 1000000000;
        int tmp2 = 294967296;
        System.out.println(-tmp2 - tmp);
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
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null){
            return 0;
        }
        int res = dfs(root, targetSum);
        res += pathSum(root.left, targetSum);
        res += pathSum(root.right, targetSum);
        return res;
    }

    public int dfs(TreeNode root, long targetSum){
        if (root == null){
            return 0;
        }
        int res = 0;
        if (root.val == targetSum){
            res ++;
        }
        res += dfs(root.left, targetSum - root.val);
        res += dfs(root.right, targetSum - root.val);
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}