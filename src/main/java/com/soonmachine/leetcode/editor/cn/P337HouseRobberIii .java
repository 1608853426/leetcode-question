//小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为
// root 。 
//
// 除了
// root 之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 如果 两个直接相连的
//房子在同一天晚上被打劫 ，房屋将自动报警。 
//
// 给定二叉树的 root 。返回 在不触动警报的情况下 ，小偷能够盗取的最高金额 。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [3,2,3,null,3,null,1]
//输出: 7 
//解释: 小偷一晚能够盗取的最高金额 3 + 3 + 1 = 7 
//
// 示例 2: 
//
// 
//
// 
//输入: root = [3,4,5,1,3,null,1]
//输出: 9
//解释: 小偷一晚能够盗取的最高金额 4 + 5 = 9
// 
//
// 
//
// 提示： 
//
// 
// 
//
// 
// 树的节点数在 [1, 10⁴] 范围内 
// 0 <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 动态规划 二叉树 👍 1945 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//java:打家劫舍 III
class P337HouseRobberIii {
    public static void main(String[] args) {
        Solution solution = new P337HouseRobberIii().new Solution();
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
        Map<TreeNode, Integer> map = new HashMap<>();
        /*public int rob(TreeNode root) {
            if (root == null){
                return 0;
            }
            if (root.left == null && root.right == null){
                return root.val;
            }
            if (map.containsKey(root)){
                return map.get(root);
            }
            //偷父节点
            int val = root.val;
            if (root.left != null){
                val += rob(root.left.left) + rob(root.left.right);
            }
            if (root.right != null){
                val += rob(root.right.left) + rob(root.right.right);
            }
            //不偷父节点
            int val2 = rob(root.left) + rob(root.right);
            map.put(root,  Math.max(val, val2));
            return Math.max(val, val2);
        }*/
        public int rob(TreeNode root) {
            int[] res = dp(root);
            return Math.max(res[0], res[1]);
        }

        int[] dp(TreeNode root){
            //0代表不偷 1代表偷
            if (root == null){
                return new int[]{0, 0};
            }
            int[] left = dp(root.left);
            int[] right = dp(root.right);

            //偷当前的
            int steal = root.val + left[0] + right[0];

            //不偷当前的
            int notSteal =  Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
            return new int[]{notSteal, steal};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}