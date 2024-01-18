//给定一个二叉树，我们在树的节点上安装摄像头。 
//
// 节点上的每个摄影头都可以监视其父对象、自身及其直接子对象。 
//
// 计算监控树的所有节点所需的最小摄像头数量。 
//
// 
//
// 示例 1： 
//
// 
//
// 输入：[0,0,null,0,0]
//输出：1
//解释：如图所示，一台摄像头足以监控所有节点。
// 
//
// 示例 2： 
//
// 
//
// 输入：[0,0,null,0,null,0,null,null,0]
//输出：2
//解释：需要至少两个摄像头来监视树的所有节点。 上图显示了摄像头放置的有效位置之一。
// 
//
// 提示： 
//
// 
// 给定树的节点数的范围是 [1, 1000]。 
// 每个节点的值都是 0。 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 695 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:监控二叉树

/**
 * 监控二叉树
 * 1. 贪心
 * 贪心策略：从叶子节点开始，如果当前节点未被覆盖，那么需要安装摄像头，如果当前节点已被覆盖，那么不需要安装摄像头
 * 从叶子节点开始，如果当前节点未被覆盖，那么需要安装摄像头，如果当前节点已被覆盖，那么不需要安装摄像头
 */
class P968BinaryTreeCameras {
    public static void main(String[] args) {
        Solution solution = new P968BinaryTreeCameras().new Solution();
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

        int result;

        public int minCameraCover(TreeNode root) {
            result = 0;
            if (root == null) {
                return 0;
            }
            if (dfs(root) == 0) {
                result++;
            }
            return result;
        }

        /**
         * 0: 未被覆盖
         * 1: 已被覆盖
         * 2: 已安装摄像头
         *
         * @param root
         * @return 返回当前节点的状态
         */
        int dfs(TreeNode root) {
            if (root == null) {
                return 1;
            }

            int left = dfs(root.left);
            int right = dfs(root.right);
            //如果左右节点有一个未被覆盖，那么当前节点需要安装摄像头
            if (left == 0 || right == 0) {
                result++;
                return 2;
            }

            //如果左右节点都被覆盖，那么当前节点未被覆盖
            if (left == 1 && right == 1) {
                return 0;
            }

            //如果左右节点都被覆盖，且有一个节点安装了摄像头，那么当前节点已被覆盖
            if (left + right >= 3) {
                return 1;
            }
            return -1;


        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}