//给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [3,9,20,null,null,15,7]
//输出：[[3],[9,20],[15,7]]
// 
//
// 示例 2： 
//
// 
//输入：root = [1]
//输出：[[1]]
// 
//
// 示例 3： 
//
// 
//输入：root = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [0, 2000] 内 
// -1000 <= Node.val <= 1000 
// 
//
// Related Topics 树 广度优先搜索 二叉树 👍 1857 👎 0

package com.soonmachine.leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

//java:二叉树的层序遍历

/**
 * 二叉树的层序遍历
 * 1. 用队列保存每一层的节点
 * 2. 每次遍历一层，将下一层的节点保存到队列中
 * 3. 遍历完一层后，将队列中的节点保存到结果中
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class P102BinaryTreeLevelOrderTraversal{
    public static void main(String[] args){
        Solution solution = new P102BinaryTreeLevelOrderTraversal().new Solution();
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            while (size -- > 0){
                TreeNode node = queue.pollFirst();
                list.add(node.val);
                if(node.left != null){
                    queue.offer(node.left);
                }
                if (node.right != null){
                    queue.offer(node.right);
                }
            }
            ans.add(list);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}