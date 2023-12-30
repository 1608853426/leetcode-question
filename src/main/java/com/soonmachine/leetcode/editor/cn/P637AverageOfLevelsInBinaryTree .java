//给定一个非空二叉树的根节点
// root , 以数组的形式返回每一层节点的平均值。与实际答案相差 10⁻⁵ 以内的答案可以被接受。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[3.00000,14.50000,11.00000]
//解释：第 0 层的平均值为 3,第 1 层的平均值为 14.5,第 2 层的平均值为 11 。
//因此返回 [3, 14.5, 11] 。
// 
//
// 示例 2: 
//
// 
//
// 
//输入：root = [3,9,20,15,7]
//输出：[3.00000,14.50000,11.00000]
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
// 树中节点数量在 [1, 10⁴] 范围内 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 469 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.*;

//java:二叉树的层平均值

/**
 * 二叉树的层平均值
 * 1. 用队列保存每一层的节点
 * 2. 每次遍历一层，将下一层的节点保存到队列中
 * 3. 遍历完一层后，将队列中的节点保存到变量中
 * 4. 计算变量的平均值，保存到结果中
 * 时间复杂度：O(n)
 */
class P637AverageOfLevelsInBinaryTree{
    public static void main(String[] args){
        Solution solution = new P637AverageOfLevelsInBinaryTree().new Solution();
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
    public List<Double> averageOfLevels(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<Double> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        queue.push(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            double val = .0f;
            int num = size;
            while (size -- > 0){
                TreeNode node = queue.pollFirst();
                val += node.val;
                if (node.left != null){
                    queue.add(node.left);
                }
                if (node.right != null){
                    queue.add(node.right);
                }
            }
            ans.add(val/num);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}