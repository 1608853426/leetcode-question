//给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。 
//
// 假设二叉树中至少有一个节点。 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入: root = [2,1,3]
//输出: 1
// 
//
// 示例 2: 
//
// 
//
// 
//输入: [1,2,3,4,null,5,6,null,null,7]
//输出: 7
// 
//
// 
//
// 提示: 
//
// 
// 二叉树的节点个数的范围是 [1,10⁴] 
// 
// -2³¹ <= Node.val <= 2³¹ - 1 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 554 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.LinkedList;
import java.util.Queue;

//java:找树左下角的值

/**
 * 找树左下角的值
 * 1. 层序遍历
 *   遍历每一层的所有节点，记录每一层的第一个节点
 *   返回最后一层的第一个节点
 * 2. dfs
 *   递归遍历每一层的所有节点，记录每一层的第一个节点
 *   返回最后一层的第一个节点
 *   时间复杂度：O(n)
 *   空间复杂度：O(n)
 */
class P513FindBottomLeftTreeValue{
    public static void main(String[] args){
        Solution solution = new P513FindBottomLeftTreeValue().new Solution();
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
    public int findBottomLeftValue(TreeNode root) {
        if (root.left == null && root.right == null){
            return root.val;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = root.val;
        while (!queue.isEmpty()){
            ans = queue.peek().val;
            int size = queue.size();
            while (size -- > 0){
                TreeNode node = queue.poll();
                if (node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
        }
        return ans;
    }

}
//leetcode submit region end(Prohibit modification and deletion)

}