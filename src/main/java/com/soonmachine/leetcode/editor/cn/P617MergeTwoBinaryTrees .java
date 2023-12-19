//给你两棵二叉树： root1 和 root2 。 
//
// 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠
//，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。 
//
// 返回合并后的二叉树。 
//
// 注意: 合并过程必须从两个树的根节点开始。 
//
// 
//
// 示例 1： 
// 
// 
//输入：root1 = [1,3,2,5], root2 = [2,1,3,null,4,null,7]
//输出：[3,4,5,5,4,null,7]
// 
//
// 示例 2： 
//
// 
//输入：root1 = [1], root2 = [1,2]
//输出：[2,2]
// 
//
// 
//
// 提示： 
//
// 
// 两棵树中的节点数目在范围 [0, 2000] 内 
// -10⁴ <= Node.val <= 10⁴ 
// 
//
// Related Topics 树 深度优先搜索 广度优先搜索 二叉树 👍 1359 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:合并二叉树

/**
 * 合并二叉树
 * 解法一：递归
 *  1. 递归终止条件：两个节点都为空
 *  2. 递归过程：合并两个节点，合并后的节点的值为两个节点的值之和
 *  3. 递归返回值：合并后的节点
 * 时间复杂度：O(min(m,n))，其中 m 和 n 分别是两个二叉树的节点个数。
 * 对两个二叉树同时进行深度优先搜索，只有当两个二叉树中的对应节点都不为空时才会对该节点进行显式合并操作，
 * 因此被访问到的节点数不会超过较小的二叉树的节点数。
 * 解法二：迭代
 * 1. 用栈模拟递归过程
 * 2. 栈中的元素是成对的，每个元素都是对应两个节点
 * 3. 每次从栈中取出一对节点，合并这两个节点
 * 4. 如果两个节点都不为空，则将合并后的节点放入栈中
 * 5. 如果两个节点有一个为空，则将不为空的节点放入栈中
 * 6. 最终栈中只有一个节点，就是合并后的二叉树的根节点
 * 时间复杂度：O(min(m,n))，其中 m 和 n 分别是两个二叉树的节点个数。
 */



class P617MergeTwoBinaryTrees {
    public static void main(String[] args) {
        Solution solution = new P617MergeTwoBinaryTrees().new Solution();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(3);
        TreeNode root2 = new TreeNode(2);
        root2.left = new TreeNode(1);
        root2.right = new TreeNode(3);
        solution.mergeTrees(root1, root2);

    }
    //leetcode submit region begin(Prohibit modification and deletion)


    class Solution {
        public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
            if (root1 == null && root2 == null) {
                return null;
            }
            if (root1 == null) {
                return root2;
            }
            if (root2 == null) {
                return root1;
            }
            TreeNode root = new TreeNode(root1.val + root2.val);
            root.left = mergeTrees(root1.left, root2.left);
            root.right = mergeTrees(root1.right, root2.right);
            return root;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}