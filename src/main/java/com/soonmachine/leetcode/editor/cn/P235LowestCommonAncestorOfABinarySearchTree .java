//给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 例如，给定如下二叉搜索树: root = [6,2,8,0,4,7,9,null,null,3,5] 
//
// 
//
// 
//
// 示例 1: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 8
//输出: 6 
//解释: 节点 2 和节点 8 的最近公共祖先是 6。
// 
//
// 示例 2: 
//
// 输入: root = [6,2,8,0,4,7,9,null,null,3,5], p = 2, q = 4
//输出: 2
//解释: 节点 2 和节点 4 的最近公共祖先是 2, 因为根据定义最近公共祖先节点可以为节点本身。 
//
// 
//
// 说明: 
//
// 
// 所有节点的值都是唯一的。 
// p、q 为不同节点且均存在于给定的二叉搜索树中。 
// 
//
// Related Topics 树 深度优先搜索 二叉搜索树 二叉树 👍 1184 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:二叉搜索树的最近公共祖先

/**
 * 二叉搜索树的最近公共祖先
 * 1. 递归
 * 利用二叉搜索树的特点，左子树的值都小于根节点，右子树的值都大于根节点
 * 1. 如果p和q都小于根节点，说明p和q都在左子树中，递归左子树
 * 2. 如果p和q都大于根节点，说明p和q都在右子树中，递归右子树
 * 3. 如果p和q一个大于根节点，一个小于根节点，说明p和q分别在左右子树中，返回根节点
 * 4. 如果p和q其中一个等于根节点，说明p和q其中一个就是根节点，返回根节点
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)
 *
 * 2. 迭代
 * 1. 利用二叉搜索树的特点，左子树的值都小于根节点，右子树的值都大于根节点
 * 2. 从根节点开始遍历，如果p和q都小于根节点，说明p和q都在左子树中，遍历左子树
 * 3. 如果p和q都大于根节点，说明p和q都在右子树中，遍历右子树
 * 4. 如果p和q一个大于根节点，一个小于根节点，说明p和q分别在左右子树中，返回根节点
 * 5. 如果p和q其中一个等于根节点，说明p和q其中一个就是根节点，返回根节点
 * 时间复杂度：O(n)
 */
class P235LowestCommonAncestorOfABinarySearchTree{
    public static void main(String[] args){
        Solution solution = new P235LowestCommonAncestorOfABinarySearchTree().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val > q.val){
            return lowestCommonAncestor(root, q, p);
        }
        while (root != null){
            if (root.val < p.val){
                root = root.right;
            }else if (root.val > q.val){
                root = root.left;
            }else {
                return root;
            }
        }
        return null;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}