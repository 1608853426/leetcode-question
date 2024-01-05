//给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。 
//
// 如果树中有不止一个众数，可以按 任意顺序 返回。 
//
// 假定 BST 满足如下定义： 
//
// 
// 结点左子树中所含节点的值 小于等于 当前节点的值 
// 结点右子树中所含节点的值 大于等于 当前节点的值 
// 左子树和右子树都是二叉搜索树 
// 
//
// 
//
// 示例 1： 
// 
// 
//输入：root = [1,null,2,2]
//输出：[2]
// 
//
// 示例 2： 
//
// 
//输入：root = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 树中节点的数目在范围 [1, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// 
//
// 
//
// 进阶：你可以不使用额外的空间吗？（假设由递归产生的隐式调用栈的开销不被计算在内） 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 723 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:二叉搜索树中的众数

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉搜索树中的众数
 * 解法一：递归
 * 1. 二叉搜索树的中序遍历是递增序列
 * 2. 用pre记录前一个节点，count记录当前节点的重复次数，maxTimes记录最大重复次数
 * 3. 如果当前节点和前一个节点值相同，count++，否则count=1
 * 4. 如果count>maxTimes，maxTimes=count，ans清空，ans.add(cur.val)
 * 5. 如果count==maxTimes，ans.add(cur.val)
 * 6. pre=cur
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * 解法二：迭代
 * 1. 用栈模拟中序遍历
 * 2. 用pre记录前一个节点，count记录当前节点的重复次数，maxTimes记录最大重复次数
 * 3. 如果当前节点和前一个节点值相同，count++，否则count=1
 * 4. 如果count>maxTimes，maxTimes=count，ans清空，ans.add(cur.val)
 * 5. 如果count==maxTimes，ans.add(cur.val)
 * 6. pre=cur
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 */
class P501FindModeInBinarySearchTree {
    public static void main(String[] args) {
        Solution solution = new P501FindModeInBinarySearchTree().new Solution();
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
        public int[] findMode(TreeNode root) {
            List<Integer> ans = new ArrayList<>();
            int maxTimes = 0;
            int count = 0;
            Stack<TreeNode> stack = new Stack<>();
            TreeNode pre = null;
            TreeNode cur = root;
            while (cur != null || !stack.isEmpty()){
                if (cur != null){
                 stack.push(cur);
                 cur = cur.left;
                }else {
                    cur = stack.pop();
                    if (pre == null || pre.val != cur.val){
                        count = 1;
                    }else {
                        count ++;
                    }
                    if (count > maxTimes){
                        maxTimes = count;
                        ans.clear();
                        ans.add(cur.val);
                    } else if (count == maxTimes) {
                        ans.add(cur.val);
                    }
                    pre = cur;
                    cur = cur.right;
                }
            }
            return ans.stream().mapToInt(Integer::intValue).toArray();
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}