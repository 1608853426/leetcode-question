//给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。 
//
// 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：root = [1,null,3,2,4,null,5,6]
//输出：[[1],[3,2,4],[5,6]]
// 
//
// 示例 2： 
//
// 
//
// 
//输入：root = [1,null,2,3,4,5,null,null,6,7,null,8,null,9,10,null,null,11,null,12,
//null,13,null,null,14]
//输出：[[1],[2,3,4,5],[6,7,8,9,10],[11,12,13],[14]]
// 
//
// 
//
// 提示： 
//
// 
// 树的高度不会超过 1000 
// 树的节点总数在 [0, 10^4] 之间 
// 
//
// Related Topics 树 广度优先搜索 👍 424 👎 0

package com.soonmachine.leetcode.editor.cn;


//java:N 叉树的层序遍历

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * N 叉树的层序遍历
 * 1. 用队列保存每一层的节点
 * 2. 每次遍历一层，将下一层的节点保存到队列中
 * 3. 遍历完一层后，将队列中的节点保存到结果中
 * 时间复杂度：O(n)
 * 空间复杂度：O(n)

 */
class P429NAryTreeLevelOrderTraversal{
    public static void main(String[] args){
        Solution solution = new P429NAryTreeLevelOrderTraversal().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        Deque<Node> queue = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null){
            return ans;
        }
        queue.push(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            while (size -- > 0){
                Node node = queue.pollFirst();
                level.add(node.val);
                queue.addAll(node.children);
            }
            ans.add(level);
        }
        return ans;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}